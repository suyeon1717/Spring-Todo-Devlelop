package com.example.todoprojectdevelop.repository;

import com.example.todoprojectdevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
