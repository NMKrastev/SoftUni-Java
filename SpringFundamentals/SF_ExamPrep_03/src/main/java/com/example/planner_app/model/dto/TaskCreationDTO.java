package com.example.planner_app.model.dto;

import com.example.planner_app.model.entity.enums.PriorityEnum;
import com.example.planner_app.validation.PastDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreationDTO {

    @NotBlank(message = "Description must not contain whitespaces!")
    @Size(min = 2, max = 50, message = "Description must be between 2 and 50 characters!")
    private String description;

    @NotBlank
    @PastDate
    private String dueDate;

    @NotNull
    private PriorityEnum priority;
}
