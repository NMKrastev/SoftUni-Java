package bg.softuni.resellerapp.model.dto;

import bg.softuni.resellerapp.model.enums.ConditionTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConditionDTO {

    private ConditionTypeEnum name;

    private String description;
}
