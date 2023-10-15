package com.example.planner_app.web;

import com.example.planner_app.model.dto.TaskCreationDTO;
import com.example.planner_app.model.entity.enums.PriorityEnum;
import com.example.planner_app.service.PriorityService;
import com.example.planner_app.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;
    private final PriorityService priorityService;

    public TaskController(TaskService taskService, PriorityService priorityService) {

        this.taskService = taskService;
        this.priorityService = priorityService;
    }

    @ModelAttribute("taskCreationDTO")
    public void initTaskCreationModel(Model model) {

        model.addAttribute("taskCreationDTO", new TaskCreationDTO());
    }

    @ModelAttribute("priorities")
    public PriorityEnum[] engines() {

        return PriorityEnum.values();
    }

    @GetMapping("/add")
    public ModelAndView addTask(ModelAndView modelAndView) {

        modelAndView.setViewName("task-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addTask(ModelAndView modelAndView,
                                @Valid TaskCreationDTO taskCreationDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("taskCreationDTO", taskCreationDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskCreationDTO", bindingResult);

            modelAndView.setViewName("redirect:/tasks/add");

            return modelAndView;

        }

        boolean isTaskCreated = this.taskService.createTask(taskCreationDTO);

        if (isTaskCreated) {

            modelAndView.setViewName("redirect:/home");

        } else {

            modelAndView.setViewName("redirect:/tasks/add");

        }

        return modelAndView;
    }

    @GetMapping("/assign/{taskId}")
    public ModelAndView assignTaskToUser(ModelAndView modelAndView,
                                         @PathVariable("taskId") Long taskId) {

        this.taskService.assignTaskToUser(taskId);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

    @GetMapping("/return/{taskId}")
    public ModelAndView returnTaskFromUser(ModelAndView modelAndView,
                                           @PathVariable("taskId") Long taskId) {

        this.taskService.returnTaskFromUser(taskId);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

    @GetMapping("/delete/{taskId}")
    public ModelAndView deleteTask(ModelAndView modelAndView,
                                           @PathVariable("taskId") Long taskId) {

        this.taskService.deleteTask(taskId);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }
}
