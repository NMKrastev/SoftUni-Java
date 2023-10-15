package com.example.planner_app.model.mapper;

import com.example.planner_app.model.dto.TaskCreationDTO;
import com.example.planner_app.model.dto.TaskDTO;
import com.example.planner_app.model.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task taskCreationDtoToTask(TaskCreationDTO taskCreationDTO);

    TaskDTO taskToTaskDTO(Task task);
}
