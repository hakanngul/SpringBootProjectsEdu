package com.hakangul.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * JWT (JSON Web Token) işlemlerini yöneten servis sınıfı
 * Bu sınıf token oluşturma, doğrulama ve token bilgilerini çıkarma işlemlerini gerçekleştirir
 */
@Component
public class JwtService {

    // JWT tokenlarını imzalamak için kullanılan gizli anahtar (Base64 formatında)
    private static final String SECRET_KEY = "RNdS5SemKK++CZ1PzkrNXkPlVM99r1Y+kmvP4mjQSWE=";

    /**
     * Kullanıcı bilgilerini kullanarak yeni bir JWT token oluşturur
     * @param userDetails Kullanıcının detay bilgileri (kullanıcı adı, roller vs.)
     * @return Oluşturulan JWT token string'i
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("role", "ADMIN");
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // Token'ın sahibini belirler (kullanıcı adı)
                .addClaims(claimsMap)
                .setIssuedAt(new Date()) // Token'ın oluşturulma tarihini ayarlar
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1)) // Token'ın geçerlilik süresi (2 saat)
                // .setExpiration(new Date(System.currentTimeMillis() + 1000 * 10)) // Token'ın geçerlilik süresi (2 saat)

                .signWith(getKey(), SignatureAlgorithm.HS256) // Token'ı gizli anahtar ile imzalar (HS256 algoritması)
                .compact(); // Token'ı string formatına çevirir
    }

    /**
     * JWT token'dan belirli bir bilgiyi çıkarmak için genel amaçlı metod
     * @param token JWT token string'i
     * @param claimsFunction Token'dan hangi bilginin çıkarılacağını belirten fonksiyon
     * @return İstenen bilgi (generic tip)
     */
    public <T> T exportToken(String token, Function<Claims, T> claimsFunction) {
        // Token'ı parse ederek claims (token içindeki bilgiler) kısmını alır
        Claims claimsBody = getClaims(token);
        return claimsFunction.apply(claimsBody); // Belirtilen fonksiyonu claims üzerinde uygular
    }

    public Object getClaimsByKey(String token, String key) {
        Claims claimsBody = getClaims(token);
        return claimsBody.get(key);
    }

    private Claims getClaims(String token) {
        return Jwts
        .parserBuilder()
        .setSigningKey(getKey()) // İmza doğrulaması için gizli anahtarı ayarlar
        .build()
        .parseClaimsJws(token) // Token'ı parse eder ve doğrular
        .getBody(); // Token'ın body kısmını (claims) alır
    }


    /**
     * JWT token'dan kullanıcı adını çıkarır
     * @param token JWT token string'i
     * @return Token'daki kullanıcı adı
     */
    public String getUsernameByToken(String token) {
       return exportToken(token, Claims::getSubject); // Subject claim'ini (kullanıcı adı) döndürür
    }

    /**
     * JWT token'ın süresi dolmuş mu kontrol eder
     * @param token JWT token string'i
     * @return Token geçerliyse true, süresi dolmuşsa false döner
     */
    public boolean isTokenExpired(String token) {
        Date expiredDate = exportToken(token, Claims::getExpiration); // Token'ın bitiş tarihini alır
        return new Date().before(expiredDate); // Şu anki tarih bitiş tarihinden önce mi kontrol eder
    }

    /**
     * JWT token imzalama için kullanılan gizli anahtarı hazırlar
     * @return HMAC SHA algoritması için uygun formatta anahtar
     */
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // Base64 string'i byte array'e çevirir
        return Keys.hmacShaKeyFor(keyBytes); // HMAC SHA için uygun Key objesi oluşturur
    }
}
