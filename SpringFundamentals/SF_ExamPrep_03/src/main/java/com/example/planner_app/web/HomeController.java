package com.example.planner_app.web;

import com.example.planner_app.model.dto.TaskDTO;
import com.example.planner_app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final TaskService taskService;

    public HomeController(TaskService taskService) {

        this.taskService = taskService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        final List<TaskDTO> userTasks = this.taskService.findUserTasks();

        final List<TaskDTO> allAvailableTasks = this.taskService.findAllAvailableTasks();

        modelAndView.addObject("userTasks", userTasks);

        modelAndView.addObject("allAvailableTasks", allAvailableTasks);

        modelAndView.setViewName("home");

        return modelAndView;
    }
}
