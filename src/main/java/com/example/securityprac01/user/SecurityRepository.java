package com.example.securityprac01.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<SecurityUser, Long> {

    Optional<SecurityUser> findByEmail(String email);
}
