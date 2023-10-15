package com.example.planner_app.model.dto;

import com.example.planner_app.model.entity.enums.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PriorityDTO {

    private final PriorityEnum name;
}
