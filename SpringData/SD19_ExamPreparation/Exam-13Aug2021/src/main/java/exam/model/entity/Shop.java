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
@Table(name = "shops")
public class Shop extends BaseEntity{

    @Column(unique = true)
    @Size(min = 4)
    private String name;

    @Column
    @Min(20000)
    private BigDecimal income;

    @Column
    @Size(min = 4)
    private String address;

    @Column(name = "employee_count")
    @Min(1)
    @Max(50)
    private int employeeCount;

    @Column(name = "shop_area")
    @Min(150)
    private int shopArea;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Town town;

}
