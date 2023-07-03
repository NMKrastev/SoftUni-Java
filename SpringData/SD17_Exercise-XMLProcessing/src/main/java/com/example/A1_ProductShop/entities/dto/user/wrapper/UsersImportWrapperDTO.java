package com.example.A1_ProductShop.entities.dto.user.wrapper;

import com.example.A1_ProductShop.entities.dto.user.UserImportDTO;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportWrapperDTO {

    @XmlElement(name = "user")
    private List<UserImportDTO> users;
}
