package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Address;
import ecommerce.myProject.Domain.Buyer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Long> {

    List<Address> findAllByBuyer(Buyer buyer);
}
