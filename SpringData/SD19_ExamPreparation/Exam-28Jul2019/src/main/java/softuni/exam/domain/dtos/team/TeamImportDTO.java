package softuni.exam.domain.dtos.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.domain.dtos.picture.PictureImportDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamImportDTO {

    @XmlElement
    private String name;

    @XmlElement
    private PictureImportDTO picture;
}
