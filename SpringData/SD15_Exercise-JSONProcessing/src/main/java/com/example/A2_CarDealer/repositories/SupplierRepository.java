package com.example.A2_CarDealer.repositories;

import com.example.A2_CarDealer.entities.Supplier;
import com.example.A2_CarDealer.entities.dto.supplier.SupplierNotImporterByPartCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("""
SELECT NEW com.example
.A2_CarDealer.entities.dto.supplier.SupplierNotImporterByPartCountDTO(s.id, s.name, COUNT(p.id))
FROM Supplier AS s
JOIN s.parts AS p
WHERE s.isImporter = FALSE
GROUP BY s.id
""")
    Optional<List<SupplierNotImporterByPartCountDTO>> searchAllByIsImporterFalseAndPartsCount();
}
