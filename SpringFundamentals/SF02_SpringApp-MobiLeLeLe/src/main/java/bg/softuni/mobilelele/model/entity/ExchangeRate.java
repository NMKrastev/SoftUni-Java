package bg.softuni.mobilelele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exchange_rates")
public class ExchangeRate extends BaseEntity {

    @Column
    @NotNull
    private String currency;

    @Column
    @NotNull
    private BigDecimal rate;
}
