package com.example.A2_CarDealer.services.supplier;

import com.example.A2_CarDealer.entities.dto.supplier.SupplierNotImporterByPartCountDTO;
import com.example.A2_CarDealer.entities.dto.supplier.wrapper.SupplierNotImporterByPartCountWrapperDTO;
import com.example.A2_CarDealer.repositories.SupplierRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A2_CarDealer.constants.Messages.SUPPLIER_NOT_IMPORTER_BY_PART_COUNT_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Paths.LOCAL_SUPPLIERS_FILE_PATH;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public String findAllLocalSuppliersByPartsCount() throws JAXBException {

        final List<SupplierNotImporterByPartCountDTO> suppliersNotImporterByPartCountDTO =
                this.supplierRepository.searchAllByIsImporterFalseAndPartsCount()
                .orElseThrow(NoSuchElementException::new);

        final SupplierNotImporterByPartCountWrapperDTO supplierNotImporterByPartCountWrapperDTO =
                new SupplierNotImporterByPartCountWrapperDTO(suppliersNotImporterByPartCountDTO);

        final JAXBContext context = JAXBContext.newInstance(SupplierNotImporterByPartCountWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(supplierNotImporterByPartCountWrapperDTO, LOCAL_SUPPLIERS_FILE_PATH.toFile());

        return SUPPLIER_NOT_IMPORTER_BY_PART_COUNT_SAVED_SUCCESSFULLY;
    }
}
