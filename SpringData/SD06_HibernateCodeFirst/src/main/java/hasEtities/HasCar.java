package hasEtities;

import jakarta.persistence.*;

@Entity
@Table(name = "has_cars")
public class HasCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    private PlateNumber plateNumber;

    public HasCar() {}

    public HasCar(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
