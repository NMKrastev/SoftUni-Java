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

    public BrandDTO addModel(ModelDTO modelDTO) {
        if (this.models == null) {
            this.models = new ArrayList<>();
        }

        this.models.add(modelDTO);

        return this;
    }
}
