package com.example.planner_app.service;

import com.example.planner_app.model.dto.TaskCreationDTO;
import com.example.planner_app.model.dto.TaskDTO;
import com.example.planner_app.model.entity.Priority;
import com.example.planner_app.model.entity.Task;
import com.example.planner_app.model.mapper.TaskMapper;
import com.example.planner_app.repository.TaskRepository;
import com.example.planner_app.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final PriorityService priorityService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper,
                       PriorityService priorityService, UserService userService,
                       CurrentUser currentUser) {

        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.priorityService = priorityService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    public boolean createTask(TaskCreationDTO taskCreationDTO) {

        final Task task = this.taskMapper.taskCreationDtoToTask(taskCreationDTO);

        final Priority priority = this.priorityService.findByName(taskCreationDTO.getPriority().name());

        task.setPriority(priority);

        Task savedTask = null;

        try {
            savedTask = this.taskRepository.save(task);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<TaskDTO> findUserTasks() {

        return this.taskRepository
                .findByUserId(this.currentUser.getId())
                .stream()
                .map(this.taskMapper::taskToTaskDTO)
                .toList();
    }

    public List<TaskDTO> findAllAvailableTasks() {

        return this.taskRepository
                .findAllByUserIdNull()
                .stream()
                .map(this.taskMapper::taskToTaskDTO)
                .toList();
    }

    public void assignTaskToUser(Long taskId) {

        final Task task = this.taskRepository.findById(taskId).get();

        task.setUser(this.userService.findByUsername(this.currentUser.getUsername()));

        this.taskRepository.save(task);
    }

    public void returnTaskFromUser(Long taskId) {

        final Task task = this.taskRepository.findById(taskId).get();

        task.setUser(null);

        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {

        this.taskRepository.deleteById(taskId);
    }
}
