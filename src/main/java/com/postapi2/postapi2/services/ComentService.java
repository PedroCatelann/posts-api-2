package com.postapi2.postapi2.services;

import com.postapi2.postapi2.domain.Coment;
import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.repositories.ComentRepository;
import com.postapi2.postapi2.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentService {
    @Autowired
    private ComentRepository repository;

    public List<Coment> findAll() {

        return repository.findAll();
    }
    public Coment insert(Coment obj) {
        return repository.save(obj);
    }
}
