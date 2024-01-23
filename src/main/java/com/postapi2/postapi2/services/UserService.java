package com.postapi2.postapi2.services;

import com.postapi2.postapi2.services.exceptions.DatabaseException;
import com.postapi2.postapi2.services.exceptions.ResourceNotFoundException;
import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.repositories.UserRepository;
import com.postapi2.postapi2.services.interfaces.InterfaceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements InterfaceService<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {

        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException("Falha ao encontrar o id: " + id));
    }
    @Override
    public User insert(User obj) {
        return repository.save(obj);
    }

    @Override
    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            entity.setName(obj.getName());
            entity.setEmail(obj.getEmail());
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
