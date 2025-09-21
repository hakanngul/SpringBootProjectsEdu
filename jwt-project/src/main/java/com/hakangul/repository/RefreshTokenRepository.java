package com.hakangul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakangul.model.RefreshToken;

@Repository
public interface  RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    //@Query(value= "FROM RefreshToken r WHERE r.refreshToken = :token")
    Optional<RefreshToken> findByRefreshToken(String token);
}
