package bg.softuni.pathfinder.model.dto.routeDTO;

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

    //private double distance; //km

    private Long id;

    private String name;

    //TODO: Think how to extract only the fullName of the author
    private String fullName;

    private LevelEnumType levelEnumType;

    private String description;

    private String pictureUrl;
}
