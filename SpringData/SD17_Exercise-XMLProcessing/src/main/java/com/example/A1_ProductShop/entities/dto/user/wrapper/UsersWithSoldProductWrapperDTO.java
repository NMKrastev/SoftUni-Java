package com.example.A1_ProductShop.entities.dto.user.wrapper;

import com.example.A1_ProductShop.entities.dto.user.UserWithSoldProductXmlDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
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
public class UsersWithSoldProductWrapperDTO {

    @XmlElement(name = "user")
    private List<UserWithSoldProductXmlDTO> users;
}
