package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Set<Product> findAllBySeller(Seller seller);
 }
