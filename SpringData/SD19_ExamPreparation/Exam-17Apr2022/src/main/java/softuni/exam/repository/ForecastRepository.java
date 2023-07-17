package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.DaysOfWeekEnum;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

// TODO:
@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<List<Forecast>> findAllByCityId(Long id);

    Optional<Forecast> findByCityIdAndDay(Long id, DaysOfWeekEnum day);

    Optional<List<Forecast>> findAllByDayAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(DaysOfWeekEnum day, int population);
}
