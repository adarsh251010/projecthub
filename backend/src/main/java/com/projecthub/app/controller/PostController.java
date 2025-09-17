package com.projecthub.app.controller;

import com.projecthub.app.model.Post;
import com.projecthub.app.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired private PostRepository repo;

    @GetMapping("/public/posts")
    public List<Post> publicPosts(){ return repo.findAll(); }

    @GetMapping("/public/posts/{slug}")
    public ResponseEntity<Post> bySlug(@PathVariable String slug){
        return repo.findBySlug(slug).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody @Valid Post p){ return ResponseEntity.ok(repo.save(p)); }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Post p){
        return repo.findById(id).map(db -> {
            db.setTitle(p.getTitle()); db.setContent(p.getContent());
            db.setSlug(p.getSlug()); db.setPublished(p.isPublished());
            return ResponseEntity.ok(repo.save(db));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}
