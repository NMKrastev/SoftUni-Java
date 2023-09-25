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
public class RouteDetailDTO {

    private Long id;

    private String fullName;

    private String description;

    private String videoUrl;

    private LevelEnumType level;

}
