package com.example.sd18_workshopmvcproject.repositories;

import com.example.sd18_workshopmvcproject.entities.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByName(String projectName);

    List<Project> findAllByIsFinished(boolean isFinished);
}
