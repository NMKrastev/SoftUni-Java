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

    // TODO: 25.9.2023 г. Find a way to calculate the distance between to points
    //private double distance; //km

    private Long id;

    private String name;

    private String fullName;

    private LevelEnumType levelEnumType;

    private String description;

    private String pictureUrl;
}
