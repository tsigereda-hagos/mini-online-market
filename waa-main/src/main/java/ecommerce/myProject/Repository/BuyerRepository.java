package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {
}
