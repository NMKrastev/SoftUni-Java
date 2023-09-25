package bg.softuni.pathfinder.model.dto.routeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllRoutesDTO {

    private Long id;

    private String name;

    private String description;

    private String pictureUrl;

}
