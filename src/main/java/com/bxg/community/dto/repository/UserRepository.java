package com.bxg.community.dto.repository;

import com.bxg.community.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
        User findByToken(String token);
}
