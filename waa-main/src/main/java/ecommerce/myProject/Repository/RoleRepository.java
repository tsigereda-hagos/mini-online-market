package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findRoleByRole(String role);
}
