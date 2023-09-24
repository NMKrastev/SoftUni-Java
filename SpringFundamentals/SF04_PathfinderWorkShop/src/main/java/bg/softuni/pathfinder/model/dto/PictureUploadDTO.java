package bg.softuni.pathfinder.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PictureUploadDTO {

    @NotEmpty
    @Size(min = 3, max = 50)
    private String title;

    @NotEmpty
    @Size(min = 4)
    private String pictureUrl;
}
