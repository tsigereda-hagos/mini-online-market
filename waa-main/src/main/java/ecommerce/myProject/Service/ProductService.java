package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Order;
import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.Review;
import ecommerce.myProject.dto.ProductRequestDto;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void deleteProduct(long id);

    Product updateProduct(ProductRequestDto product, long id);

    List<Review> getReviewsOfProduct(long id);

    List<Order> getOrdersOfProduct(long id);
}
