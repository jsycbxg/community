package com.bxg.community.dto.servrce.impl;

import com.bxg.community.dto.User;
import com.bxg.community.dto.repository.UserRepository;
import com.bxg.community.dto.servrce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User sava(User user) {
        return repository.save(user);
    }
}
