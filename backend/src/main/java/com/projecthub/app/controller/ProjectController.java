package com.projecthub.app.controller;

import com.projecthub.app.model.Project;
import com.projecthub.app.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired private ProjectRepository repo;

    @GetMapping("/public/projects")
    public List<Project> all(){ return repo.findAll(); }

    @PostMapping("/projects")
    public ResponseEntity<Project> create(@RequestBody @Valid Project p){ return ResponseEntity.ok(repo.save(p)); }

    @PutMapping("/projects/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Project p){
        return repo.findById(id).map(db -> {
            db.setTitle(p.getTitle()); db.setDescription(p.getDescription());
            db.setTags(p.getTags()); db.setGithubUrl(p.getGithubUrl());
            db.setLiveUrl(p.getLiveUrl()); db.setImageUrl(p.getImageUrl());
            return ResponseEntity.ok(repo.save(db));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}
