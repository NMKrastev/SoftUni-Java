package bg.softuni.mobilelele.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeRatesDTO {

    private String base;

    private Map<String, BigDecimal> rates;
}
