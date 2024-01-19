package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        return repository.findAll();
    }

    public User findById(Long id) throws Exception {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new Exception("Falha ao encontrar o id: " + id));
    }
    public User insert(User obj) {
        return repository.save(obj);
    }
}
