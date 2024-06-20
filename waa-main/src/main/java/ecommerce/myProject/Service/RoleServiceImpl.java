package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Role;
import ecommerce.myProject.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl  implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByRole(name).get();
    }
}
