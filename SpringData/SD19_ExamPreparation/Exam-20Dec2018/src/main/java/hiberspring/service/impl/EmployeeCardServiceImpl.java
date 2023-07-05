package hiberspring.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import hiberspring.domain.dtos.EmployeeCardImportDTO;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static hiberspring.common.Constants.*;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final FileUtil fileUtil;
    private final ModelMapper mapper;
    private final Gson gson;
    private final StringBuilder sb;
    private final EmployeeCardRepository employeeCardRepository;

    @Autowired
    public EmployeeCardServiceImpl(FileUtil fileUtil, ModelMapper mapper, Gson gson, StringBuilder sb, EmployeeCardRepository employeeCardRepository) {
        this.fileUtil = fileUtil;
        this.mapper = mapper;
        this.gson = gson;
        this.sb = sb;
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() != 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return fileUtil.readFile(PATH_TO_FILES + EMPLOYEES_CARDS_FILE);
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws FileNotFoundException {

        final Type type = new TypeToken<List<EmployeeCardImportDTO>>(){}.getType();

        final String filePath = PATH_TO_FILES + EMPLOYEES_CARDS_FILE;

        final JsonReader reader = new JsonReader(new FileReader(filePath));

        final List<EmployeeCardImportDTO> employeesCardImportDTO = this.gson.fromJson(reader, type);

        for (EmployeeCardImportDTO cardDTO : employeesCardImportDTO) {

            try {

                final EmployeeCard card = this.mapper.map(cardDTO, EmployeeCard.class);

                this.employeeCardRepository.saveAndFlush(card);

                this.sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, EMPLOYEE_CARD, card.getNumber()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
