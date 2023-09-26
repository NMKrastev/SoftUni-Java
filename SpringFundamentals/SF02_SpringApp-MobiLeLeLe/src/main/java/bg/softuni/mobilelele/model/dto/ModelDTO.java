package bg.softuni.mobilelele.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelDTO {

    private Long id;

    private String name;

    private String category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

}
