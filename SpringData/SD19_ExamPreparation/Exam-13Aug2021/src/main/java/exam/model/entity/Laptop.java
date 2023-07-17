package exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    @Column(name = "mac_address", unique = true)
    @Size(min = 8)
    private String macAddress;

    @Column(name = "cpu_speed")
    @Min(1)
    private Double cpuSpeed;

    @Column
    @Min(8)
    @Max(128)
    private int ram;

    @Column
    @Min(128)
    @Max(1024)
    private int storage;

    @Column(columnDefinition = "TEXT")
    @Size(min = 10)
    private String description;

    @Column
    @Min(1)
    private BigDecimal price;

    @Enumerated
    @Column(nullable = false)
    private WarrantyType warrantyType;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Shop shop;
}
