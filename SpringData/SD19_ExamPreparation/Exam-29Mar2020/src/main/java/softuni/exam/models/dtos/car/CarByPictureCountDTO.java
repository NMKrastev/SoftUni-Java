package softuni.exam.models.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarByPictureCountDTO {

    private String make;

    private String model;

    private long kilometers;

    private LocalDate registeredOn;

    private long numberOfPictures;
}
