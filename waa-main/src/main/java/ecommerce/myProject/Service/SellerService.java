package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.Seller;

import java.util.List;
import java.util.Set;


public interface SellerService {

    List<Seller> getAllSellers();

    Seller getSellerById(long id);

    Seller addSeller(Seller seller);

    void deleteSeller(long id);

    Set<Product> findProducts(long id);

    Product addProduct(Product product, long id);


    Seller approveSeller(long id);
}
