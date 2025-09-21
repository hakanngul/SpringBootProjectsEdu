package com.hakangul.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JWT kimlik doğrulama filtresi
 * Her HTTP isteğinde çalışarak JWT token'ını doğrular ve kullanıcı kimlik bilgilerini SecurityContext'e ekler
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // JWT işlemlerini gerçekleştiren servis
    @Autowired
    private JwtService jwtService;

    // Kullanıcı detaylarını yüklemek için kullanılan servis
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Her HTTP isteğinde çalışan ana filtre metodu
     * JWT token'ını kontrol eder ve geçerliyse kullanıcıyı kimlik doğrulaması yapar
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header, token, username;
        
        // Authorization header'ını al
        // Bearer ile başlayıp ..... token gelir.
        header = request.getHeader("Authorization");
        
        // Header yoksa veya Bearer ile başlamıyorsa, filtreyi geç ve devam et
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        // "Bearer " kısmını çıkararak sadece token'ı al (7 karakter sonrasını al)
        token = header.substring(7);
        
        try {
            // Token'dan kullanıcı adını çıkar
            username = jwtService.getUsernameByToken(token);
            
            // Username varsa ve henüz kimlik doğrulaması yapılmamışsa
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // Kullanıcı detaylarını veritabanından yükle
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                
                // Kullanıcı bulunduysa ve token süresi dolmamışsa (NOT: burada mantık hatası var, !isTokenExpired olmalı)
                if (userDetails != null && jwtService.isTokenExpired(token)) {
                    // Kullanıcıyı SecurityContext'e ekle - kimlik doğrulaması yap
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                    authentication.setDetails(userDetails);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

        } catch (ExpiredJwtException e) {
            // Token süresi dolmuş hatası
            System.out.println("Token Süresi dolmuştur " + e.getMessage());
        } catch (UsernameNotFoundException e) {
            // Genel hata yakalama
            System.out.println("Genel bir hata oluştu : "+ e.getLocalizedMessage());
        } 

        // Filtre zincirini devam ettir
        filterChain.doFilter(request, response);
    }

}
