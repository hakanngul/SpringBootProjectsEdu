package com.hakangul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakangul.model.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Long>{

    //@Query(value = "FROM User where username = :username")
    Optional<User> findByUsername(String username);
}
