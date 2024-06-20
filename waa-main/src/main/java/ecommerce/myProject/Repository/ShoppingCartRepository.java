package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Buyer;
import ecommerce.myProject.Domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

    ShoppingCart findShoppingCartByBuyer(Buyer buyer);
    ShoppingCart findFirstByBuyer(Buyer buyer);
}
