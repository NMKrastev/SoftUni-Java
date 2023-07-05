package hiberspring.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import hiberspring.domain.dtos.BranchImportDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.service.BranchService;
import hiberspring.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static hiberspring.common.Constants.*;

@Service
public class BranchServiceImpl implements BranchService {

    private final Gson gson;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final StringBuilder sb;
    private final BranchRepository branchRepository;
    private final TownRepository townRepository;

    public BranchServiceImpl(Gson gson, ModelMapper mapper, FileUtil fileUtil, StringBuilder sb,
                             BranchRepository branchRepository, TownRepository townRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.sb = sb;
        this.branchRepository = branchRepository;
        this.townRepository = townRepository;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() != 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readFile(PATH_TO_FILES + BRANCHES_FILE);
    }

    @Override
    public String importBranches(String branchesFileContent) throws FileNotFoundException {

        final Type type = new TypeToken<List<BranchImportDTO>>(){}.getType();

        final String filePath = PATH_TO_FILES + BRANCHES_FILE;

        final JsonReader reader = new JsonReader(new FileReader(filePath));

        final List<BranchImportDTO> branchesImportDTO = this.gson.fromJson(reader, type);

        for (BranchImportDTO branchDTO : branchesImportDTO) {

            try {

                final Town town = this.townRepository.findByName(branchDTO.getTown());

                final Branch branch = this.mapper.map(branchDTO, Branch.class);

                branch.setTown(town);

                this.branchRepository.saveAndFlush(branch);

                this.sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, branch.getName(), branch.getTown().getName()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}
