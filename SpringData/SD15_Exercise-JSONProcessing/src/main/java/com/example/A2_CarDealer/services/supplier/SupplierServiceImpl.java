package com.example.A2_CarDealer.services.supplier;

import com.example.A2_CarDealer.entities.dto.supplier.SupplierNotImporterByPartCountDTO;
import com.example.A2_CarDealer.repositories.SupplierRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A2_CarDealer.constants.Messages.SUPPLIER_NOT_IMPORTER_BY_PART_COUNT_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Paths.LOCAL_SUPPLIERS_FILE_PATH;
import static com.example.A2_CarDealer.utils.Utils.writeJsonIntoFile;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final Gson gson;
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(Gson gson, SupplierRepository supplierRepository) {
        this.gson = gson;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public String findAllLocalSuppliersByPartsCount() throws IOException {

        final List<SupplierNotImporterByPartCountDTO> suppliersNotImporterByPartCountDTO =
                this.supplierRepository.searchAllByIsImporterFalseAndPartsCount()
                .orElseThrow(NoSuchElementException::new);

        writeJsonIntoFile(this.gson, suppliersNotImporterByPartCountDTO, LOCAL_SUPPLIERS_FILE_PATH);

        return SUPPLIER_NOT_IMPORTER_BY_PART_COUNT_SAVED_SUCCESSFULLY;
    }
}
