package softuni.exam.instagraphlite.models.dtos.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.instagraphlite.models.dtos.picture.PicturePathDTO;
import softuni.exam.instagraphlite.models.dtos.user.UserUsernameDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDTO {

    @XmlElement
    private String caption;

    @XmlElement
    private UserUsernameDTO user;

    @XmlElement
    private PicturePathDTO picture;
}
