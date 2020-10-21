package com.surak.issuemanagement.service.impl;

import com.surak.issuemanagement.entity.User;
import com.surak.issuemanagement.repository.UserRepository;
import com.surak.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        if(user.getEmail()==null){
            throw new IllegalArgumentException("User email cannot be null!");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
