package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.seller.SellerImportDTO;
import softuni.exam.models.dtos.seller.SellerImportWrapperDTO;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.INVALID_SELLER;
import static softuni.exam.constant.Message.SUCCESSFULLY_ADDED_SELLER;
import static softuni.exam.constant.Paths.SELLERS_FILE_PATH;

@Service
public class SellerServiceImpl implements SellerService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(ModelMapper mapper, SellerRepository sellerRepository) {
        this.mapper = mapper;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return new String(Files.readAllBytes(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {

        final FileReader reader = new FileReader(SELLERS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(SellerImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final SellerImportWrapperDTO sellersImportWrapperDTO = (SellerImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<SellerImportDTO> sellersDTO = sellersImportWrapperDTO.getSellers();

        sellersDTO
                .stream()
                .map(sellerDTO -> this.mapper.map(sellerDTO, Seller.class))
                .collect(Collectors.toList())
                .forEach(seller -> {

                    try {

                        this.sellerRepository.saveAndFlush(seller);

                        this.sb.append(String.format(SUCCESSFULLY_ADDED_SELLER, seller.getLastName(), seller.getEmail()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(INVALID_SELLER).append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
