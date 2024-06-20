package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Buyer;
import ecommerce.myProject.Domain.Order;
import ecommerce.myProject.Domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {

    List<Order> findAllByBuyer(Buyer buyer);

    Order findFirstByProduct(Product product);

    List<Order> findAllByProduct(Product product);
}
