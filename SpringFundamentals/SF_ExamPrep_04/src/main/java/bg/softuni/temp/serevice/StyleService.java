package bg.softuni.temp.serevice;

import bg.softuni.temp.model.entity.Style;
import bg.softuni.temp.model.entity.enums.StyleEnum;
import bg.softuni.temp.repository.StyleRepository;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {

        this.styleRepository = styleRepository;
    }

    public Style findStyle(StyleEnum styleByName) {

        final StyleEnum style = StyleEnum.valueOf(styleByName.name());

        return this.styleRepository.findByName(style);
    }
}
