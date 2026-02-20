package com.techie.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techie.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}