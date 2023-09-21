package bg.softuni.pathfinder.service.imp;

import bg.softuni.pathfinder.model.entity.Role;
import bg.softuni.pathfinder.model.enums.RoleEnumType;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getUserRole() {

        return this.roleRepository.findByName(RoleEnumType.USER);
    }
}
