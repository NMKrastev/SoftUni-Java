package hasEtities;

import jakarta.persistence.*;

@Entity
@Table(name = "has_plate_number")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "plate_number")
    private String number;

    //No need for the plateNumber to know about the Car
    //It's just an example of unidirectional relation
    @OneToOne(targetEntity = HasCar.class, mappedBy = "plateNumber")
    private HasCar hasCar;

    public PlateNumber() {}

    public PlateNumber(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
