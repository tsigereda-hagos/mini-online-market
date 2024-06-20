package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.ShoppingCart;


public interface ShoppingCartService {
    Product addProductToShoppingCart(Product product);

    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

    void deleteShoppingCart(ShoppingCart shoppingCart);
}
