package com.postapi2.postapi2.controller;

import com.postapi2.postapi2.domain.Coment;
import com.postapi2.postapi2.domain.Post;
import com.postapi2.postapi2.domain.User;
import com.postapi2.postapi2.services.ComentService;
import com.postapi2.postapi2.services.PostService;
import com.postapi2.postapi2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/coments")
public class ComentController {

    @Autowired
    private ComentService service;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Coment>> findAll() {
        List<Coment> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    private ResponseEntity<Coment> insert(@RequestBody Coment obj) throws Exception {
        Post post = postService.findById(obj.getPost().getId());
        User user = userService.findById(obj.getUser().getId());
        user.getComentList().add(obj);
        post.getComentList().add(obj);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Coment> update (@PathVariable Long id, @RequestBody Coment obj) {
        obj = service.update(id, obj);

        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
