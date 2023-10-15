package com.example.planner_app.service;

import com.example.planner_app.model.entity.Priority;
import com.example.planner_app.model.entity.enums.PriorityEnum;
import com.example.planner_app.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> getAllPriorities() {

        return this.priorityRepository
                .findAll();
    }

    public Priority findByName(String name) {

        final PriorityEnum findByName = PriorityEnum.valueOf(name);

        return this.priorityRepository.findByName(findByName);
    }
}
