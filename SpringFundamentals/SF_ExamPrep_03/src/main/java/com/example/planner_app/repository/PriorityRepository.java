package com.example.planner_app.repository;

import com.example.planner_app.model.entity.Priority;
import com.example.planner_app.model.entity.enums.PriorityEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {


    Priority findByName(PriorityEnum name);

    List<Priority> findAllByTasks(PriorityEnum name);
}
