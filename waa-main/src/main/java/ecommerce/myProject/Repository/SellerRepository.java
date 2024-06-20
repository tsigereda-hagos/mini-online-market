package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
}
