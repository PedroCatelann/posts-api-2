package com.postapi2.postapi2.controller;

import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping
    private ResponseEntity<List<Post>> findAll() {
        List<Post> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    private ResponseEntity<Post> insert(@RequestBody Post obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

}
