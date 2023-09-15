package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.repository.RoleRepository;
import bg.softuni.mobilelele.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public String findAllRoles() {

        final StringBuilder sb = new StringBuilder();

        final List<UserRoleEntity> allRoles = this.roleRepository.findAll();

        for (UserRoleEntity role : allRoles) {
            sb.append(role).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
