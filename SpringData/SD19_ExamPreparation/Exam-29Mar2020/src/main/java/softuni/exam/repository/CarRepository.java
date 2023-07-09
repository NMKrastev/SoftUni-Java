package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dtos.car.CarByPictureCountDTO;
import softuni.exam.models.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT NEW softuni.exam.models.dtos.car.CarByPictureCountDTO(c.make, c.model, c.kilometers, c.registeredOn, COUNT(p.id)) " +
            "FROM Car AS c JOIN c.pictures AS p " +
            "GROUP BY c.id, c.make " +
            "ORDER BY COUNT(p.id) DESC, c.make")
    List<CarByPictureCountDTO> findAllCarsOrderByPicturesCount();
}
