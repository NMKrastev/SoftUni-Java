package bg.softuni.pathfinder.model.dto.routeDTO;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUrlDTO;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AllRoutesDTO {

    private Long id;

    private String name;

    private String description;

    private Set<PictureUrlDTO> picturesUrl;

    public AllRoutesDTO() {
        this.picturesUrl = new LinkedHashSet<>();
    }
}
