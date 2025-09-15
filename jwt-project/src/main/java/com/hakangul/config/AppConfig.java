package com.hakangul.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hakangul.model.User;
import com.hakangul.repository.UserRepository;

/**
 * Spring Security konfigürasyon sınıfı
 * Bu sınıf authentication (kimlik doğrulama) ve password encoding (şifre şifreleme) işlemlerini yapılandırır
 */
@Configuration
public class AppConfig {

    // UserRepository bağımlılığını otomatik olarak enjekte eder
    @Autowired
    private UserRepository userRepository;

    /**
     * UserDetailsService bean'i oluşturur
     * Bu servis, kullanıcı adına göre kullanıcı bilgilerini veritabanından çeker
     * Spring Security tarafından authentication işlemi sırasında kullanılır
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Veritabanından kullanıcı adına göre kullanıcıyı arar
                Optional<User> optionalUser = userRepository.findByUsername(username);
                
                // Kullanıcı bulunduysa User nesnesini döndürür
                // User sınıfı UserDetails interface'ini implement etmelidir
                if (optionalUser.isPresent()) {
                    return optionalUser.get();
                }
                
                // Kullanıcı bulunamazsa null döner
                // Alternatif olarak UsernameNotFoundException fırlatılabilir
                return null;
            }
        };
    }

    /**
     * Authentication Provider bean'i oluşturur
     * Bu provider, kullanıcı kimlik doğrulama işlemlerini gerçekleştirir
     * UserDetailsService ve PasswordEncoder'ı kullanarak authentication yapar
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // DAO tabanlı authentication provider oluşturur
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService());
        
        // Şifre şifreleme algoritmasını ayarlar
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        
        return authenticationProvider;
    }

    /**
     * Password Encoder bean'i oluşturur
     * BCrypt algoritması kullanarak şifreleri güvenli bir şekilde hash'ler
     * BCrypt, salt kullanarak şifreleri şifreler ve brute force saldırılarına karşı dirençlidir
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authentication Manager bean'i oluşturur
     * Spring Security'nin merkezi authentication bileşenidir
     * Tüm authentication isteklerini koordine eder
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
