package bg.softuni.mobilelele.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDTO {

    private String name;

    private List<ModelDTO> models = new ArrayList<>();
}
