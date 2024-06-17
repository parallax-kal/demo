package com.demo.demo.repositories;

import com.demo.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmailOrPhoneNumber(String s, String s1);
    Optional<User> findUserByEmail(String s);
}
