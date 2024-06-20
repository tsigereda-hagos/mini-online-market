package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
