package com.projecthub.app.repo;
import com.projecthub.app.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjectRepository extends JpaRepository<Project, Long> {}
