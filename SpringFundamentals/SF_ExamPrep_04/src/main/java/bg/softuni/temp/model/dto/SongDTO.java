package bg.softuni.temp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {

    private Long id;

    private String performer;

    private String title;

    private Integer duration;

    private String releaseDate;

    private StyleDTO style;
    
}
