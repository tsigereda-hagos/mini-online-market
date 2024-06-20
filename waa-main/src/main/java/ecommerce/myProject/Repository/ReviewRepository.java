package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Buyer;
import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByBuyer(Buyer buyer);
    List<Review> findAll();
    List<Review> findAllByProduct(Product product);
}
