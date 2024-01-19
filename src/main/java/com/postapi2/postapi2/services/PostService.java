package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Post findById(Long id) throws Exception {
        Optional<Post> obj = repository.findById(id);

        return obj.orElseThrow(() -> new Exception("Falha ao encontrar o id: " + id));
    }
}
