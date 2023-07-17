package exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import exam.model.dtos.laptop.LaptopImportDTO;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static exam.constant.FilePath.LAPTOPS_FILE_PATH;
import static exam.constant.Message.*;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;

    public LaptopServiceImpl(Gson gson, ModelMapper mapper, FileUtil fileUtil,
                             LaptopRepository laptopRepository, ShopRepository shopRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.sb = new StringBuilder();
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return this.fileUtil.readFile(LAPTOPS_FILE_PATH);
    }

    @Override
    public String importLaptops() throws IOException {

        final JsonReader reader = new JsonReader(new FileReader(LAPTOPS_FILE_PATH.toFile()));

        final Type type = new TypeToken<List<LaptopImportDTO>>(){}.getType();

        final List<LaptopImportDTO> laptopsImportDTO = this.gson.fromJson(reader, type);

        laptopsImportDTO
                .forEach(laptopDTO -> {

                    final Shop shop = this.shopRepository.findByName(laptopDTO.getShop().getName());

                    final Laptop laptop = this.mapper.map(laptopDTO, Laptop.class);

                    laptop.setShop(shop);

                    try {

                        this.laptopRepository.saveAndFlush(laptop);

                        this.sb.append(String.format(SUCCESSFUL_LAPTOP_IMPORT, laptop.getClass().getSimpleName(),
                                        laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, laptop.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {

        final List<Laptop> laptops = this.laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddress();

        laptops
                .forEach(laptop -> this.sb.append(String.format(PRINT_FORMAT, laptop.getMacAddress(),
                                laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage(), laptop.getPrice(),
                                laptop.getShop().getName(), laptop.getShop().getTown().getName()))
                        .append(System.lineSeparator()));

        return this.sb.toString();
    }
}
