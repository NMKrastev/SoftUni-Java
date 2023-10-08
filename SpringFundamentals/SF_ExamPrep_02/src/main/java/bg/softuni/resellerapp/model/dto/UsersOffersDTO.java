package bg.softuni.resellerapp.model.dto;

import bg.softuni.resellerapp.model.entity.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class UsersOffersDTO {

    private Long id;

    private String description;

    private BigDecimal price;

    private Condition condition;

    private UserDTO seller;
}
