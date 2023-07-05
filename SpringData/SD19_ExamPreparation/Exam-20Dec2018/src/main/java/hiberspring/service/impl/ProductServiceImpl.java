package hiberspring.service.impl;

import hiberspring.domain.dtos.ProductImportDTO;
import hiberspring.domain.dtos.wrapper.ProductImportWrapperDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.ProductService;
import hiberspring.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static hiberspring.common.Constants.*;
import static hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;


@Service
public class ProductServiceImpl implements ProductService {

    private final FileUtil fileUtil;

    private final ModelMapper mapper;
    private final StringBuilder sb;
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    public ProductServiceImpl(FileUtil fileUtil, ModelMapper mapper, StringBuilder sb,
                              ProductRepository productRepository, BranchRepository branchRepository) {
        this.fileUtil = fileUtil;
        this.mapper = mapper;
        this.sb = sb;
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() != 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(PATH_TO_FILES + PRODUCTS_FILE)));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {

        final FileReader reader = new FileReader(PATH_TO_FILES + PRODUCTS_FILE);

        final JAXBContext context = JAXBContext.newInstance(ProductImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ProductImportWrapperDTO productImportWrapperDTO = (ProductImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<ProductImportDTO> productsDTO = productImportWrapperDTO.getProducts();

        for (ProductImportDTO productDTO : productsDTO) {

            try {

                final Branch branch = this.branchRepository.findByName(productDTO.getBranch());

                final Product product = this.mapper.map(productDTO, Product.class);

                product.setBranch(branch);

                this.productRepository.saveAndFlush(product);

                this.sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, product.getClass().getSimpleName(), product.getName()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }
}