package bg.softuni.mobilelele.repository;

import bg.softuni.mobilelele.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, String> {
}
