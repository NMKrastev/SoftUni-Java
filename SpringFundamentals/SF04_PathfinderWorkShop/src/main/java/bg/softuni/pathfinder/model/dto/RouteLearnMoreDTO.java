package bg.softuni.pathfinder.model.dto;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.enums.LevelEnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteLearnMoreDTO {

    private double distance; //km

    //TODO: Think how to extract only the fullName of the author
    private User author;

    private String levelEnumType;

    private String description;
}
