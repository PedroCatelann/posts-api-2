package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {

        return repository.findAll();
    }
    public Post insert(Post obj) {
        return repository.save(obj);
    }
}
