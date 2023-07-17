package exam.service.impl;

import exam.model.dtos.shop.ShopImportDTO;
import exam.model.dtos.shop.ShopImportWrapperDTO;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static exam.constant.FilePath.SHOPS_FILE_PATH;
import static exam.constant.Message.INVALID_ENTITY;
import static exam.constant.Message.SUCCESSFUL_SHOP_IMPORT;

@Service
public class ShopServiceImpl implements ShopService {

    private final StringBuilder sb;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;

    @Autowired
    public ShopServiceImpl(ModelMapper mapper, FileUtil fileUtil,
                           ShopRepository shopRepository, TownRepository townRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.sb = new StringBuilder();
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return this.fileUtil.readFile(SHOPS_FILE_PATH);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        final FileReader reader = new FileReader(SHOPS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ShopImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ShopImportWrapperDTO shopImportWrapperDTO = (ShopImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<ShopImportDTO> shopsImportDTO = shopImportWrapperDTO.getShops();

        shopsImportDTO
                .forEach(shopDTO -> {

                    final Town town = this.townRepository.findByName(shopDTO.getTown().getName());

                    final Shop shop = this.mapper.map(shopDTO, Shop.class);

                    shop.setTown(town);

                    try {

                        this.shopRepository.saveAndFlush(shop);

                        this.sb.append(String.format(SUCCESSFUL_SHOP_IMPORT,
                                        shop.getClass().getSimpleName(), shop.getName(), shop.getIncome()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, shop.getClass().getSimpleName().toLowerCase()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
