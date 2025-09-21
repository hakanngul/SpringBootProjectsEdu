package com.hakangul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hakangul.jwt.AuthEntryPoint;
import com.hakangul.jwt.JwtAuthenticationFilter;

/**
 * Spring Security yapılandırma sınıfı
 * JWT tabanlı kimlik doğrulama ve yetkilendirme işlemlerini yönetir
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Kimlik doğrulama endpoint'i
    public static final String AUTHENTICATE = "/authenticate";
    // Kayıt endpoint'i
    public static final String REGISTER = "/register";
    public static final String REFRESH_TOKEN = "/refresh-token";

    // Kimlik doğrulama sağlayıcısı - kullanıcı bilgilerini doğrular
    @Autowired
    private AuthenticationProvider authenticationProvider;

    // JWT kimlik doğrulama filtresi - gelen isteklerdeki JWT token'ları işler
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthEntryPoint authEntryPoint;
    /**
     * Güvenlik filtre zincirini yapılandırır
     * @param httpSecurity HTTP güvenlik yapılandırma nesnesi
     * @return Yapılandırılmış SecurityFilterChain
     * @throws Exception Yapılandırma sırasında oluşabilecek hatalar
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // CSRF korumasını devre dışı bırak (REST API için gerekli değil)
                .csrf(csrf -> csrf.disable())
                // HTTP isteklerini yetkilendir
                .authorizeHttpRequests(request -> request
                        // /authenticate ve /register endpoint'lerine herkesin erişebilmesine izin ver
                        .requestMatchers(AUTHENTICATE, REGISTER,REFRESH_TOKEN)
                        .permitAll()
                        // Diğer tüm istekler için kimlik doğrulama gerekli
                        .anyRequest()
                        .authenticated())
                // Oturum yönetimini stateless olarak ayarla (JWT kullandığımız için)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Kimlik doğrulama sağlayıcısını ekle
                .authenticationProvider(authenticationProvider)
                // JWT filtresini UsernamePasswordAuthenticationFilter'dan önce çalışacak şekilde ekle
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint));
    
        return httpSecurity.build();
    }
}
