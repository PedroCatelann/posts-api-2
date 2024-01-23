package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.Coment;
import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.repositories.ComentRepository;
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
public class ComentService implements InterfaceService<Coment> {
    @Autowired
    private ComentRepository repository;

    @Override
    public List<Coment> findAll() {

        return repository.findAll();
    }

    @Override
    public Coment findById(Long id) {
        Optional<Coment> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException("Falha ao encontrar o id: " + id));
    }

    @Override
    public Coment insert(Coment obj) {
        return repository.save(obj);
    }

    @Override
    public Coment update(Long id, Coment obj) {
        try {
            Coment entity = repository.getReferenceById(id);
            entity.setText(obj.getText());
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
