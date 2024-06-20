package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Role;

public interface RoleService {

    Iterable<Role> getAllRoles();

    Role getRoleByName(String name);

}
