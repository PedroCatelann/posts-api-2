package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.repositories.PostRepository;
import com.postapi2.postapi2.services.exceptions.DatabaseException;
import com.postapi2.postapi2.services.exceptions.ResourceNotFoundException;
import com.postapi2.postapi2.services.interfaces.InterfaceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements InterfaceService<Post> {
    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> findAll() {

        return repository.findAll();
    }
    @Override
    public Post insert(Post obj) {
        return repository.save(obj);
    }

    @Override
    public Post findById(Long id)  {
        Optional<Post> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException("Falha ao encontrar o id: " + id));
    }

    @Override
    public Post update(Long id, Post obj) {
        try {
            Post entity = repository.getReferenceById(id);
            entity.setBody(obj.getBody());
            entity.setTitle(obj.getTitle());
            entity.setDate(Instant.now());
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    @Override
    public void delete(Long id) {
        try{
            if(repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw  new ResourceNotFoundException(id);
            }
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
