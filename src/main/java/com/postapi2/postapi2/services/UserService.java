package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        return repository.findAll();
    }
    public User insert(User obj) {
        return repository.save(obj);
    }
}
