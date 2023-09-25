package bg.softuni.pathfinder.model.dto.routeDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RouteRegisterDTO {

    @NotEmpty
    @Size(min = 5)
    private String name;

    @NotEmpty
    @Size(min = 5)
    private String description;

    @NotEmpty
    private MultipartFile gpxCoordinates;

    @NotEmpty
    private String level;

    @NotEmpty
    private String videoUrl;

    @NotEmpty
    private Set<String> categories;

    public RouteRegisterDTO() {
        this.categories = new HashSet<>();
    }
}

