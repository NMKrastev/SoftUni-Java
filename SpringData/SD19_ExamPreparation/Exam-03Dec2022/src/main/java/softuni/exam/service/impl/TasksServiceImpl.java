package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.task.TaskImportDTO;
import softuni.exam.models.dto.task.TaskImportWrapperDTO;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constant.Message.*;

@Service
public class TasksServiceImpl implements TasksService {

    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final ValidationUtils validationUtils;
    private final XMLParser xmlParser;
    private final TasksRepository tasksRepository;
    private final CarsRepository carsRepository;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;

    @Autowired
    public TasksServiceImpl(ModelMapper mapper, ValidationUtils validationUtils,
                            XMLParser xmlParser, TasksRepository tasksRepository, CarsRepository carsRepository,
                            MechanicsRepository mechanicsRepository, PartsRepository partsRepository) {
        this.carsRepository = carsRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.sb = new StringBuilder();
        this.mapper = mapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.tasksRepository = tasksRepository;
    }

    @Override
    public boolean areImported() {
        return this.tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {

        final TaskImportWrapperDTO tasksImportWrapperDTO =
                this.xmlParser.fromFile(Path.of(TASKS_FILE_PATH).toFile(), TaskImportWrapperDTO.class);

        final List<TaskImportDTO> tasksImportDTO = tasksImportWrapperDTO.getTasks();

        for (TaskImportDTO taskDTO : tasksImportDTO) {

            final Optional<Car> car = this.carsRepository.findById(taskDTO.getCar().getId());

            final Optional<Mechanic> mechanic = this.mechanicsRepository.findMechanicByFirstName(taskDTO.getMechanic().getFirstName());

            final Optional<Part> part = this.partsRepository.findById(taskDTO.getPart().getId());

            if (!this.validationUtils.isValid(taskDTO) || car.isEmpty()
                    || mechanic.isEmpty() || part.isEmpty()) {

                    this.sb.append(String.format(INVALID_ENTITY, TASK))
                            .append(System.lineSeparator());
                    continue;
                }

                final Task task = this.mapper.map(taskDTO, Task.class);

                task.setCar(car.get());
                task.setMechanic(mechanic.get());
                task.setPart(part.get());

                this.tasksRepository.saveAndFlush(task);

                this.sb.append(String.format(SUCCESSFUL_TASK_IMPORT, TASK,
                                task.getPrice().setScale(2)))
                        .append(System.lineSeparator());
       }

        return this.sb.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {

        final List<Task> exportResult = this.tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe);

        exportResult
                .forEach(result ->
                        this.sb.append(String.format(EXPORT,
                                        result.getCar().getCarMake(), result.getCar().getCarModel(), result.getCar().getKilometers(),
                                        result.getMechanic().getFullName(), result.getId(),
                                        result.getCar().getEngine(),
                                        result.getPrice().setScale(2)))
                                .append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
