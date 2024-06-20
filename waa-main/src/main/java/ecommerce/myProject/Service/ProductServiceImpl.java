package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Order;
import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.Review;
import ecommerce.myProject.Repository.OrderRepository;
import ecommerce.myProject.Repository.ProductRepository;
import ecommerce.myProject.Repository.ReviewRepository;
import ecommerce.myProject.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Product> getAllProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow();
    }
    @Override
    public void deleteProduct(long id) {
        Product product = getProductById(id);
        Order order = orderRepository.findFirstByProduct(product);
        if(order == null){
            productRepository.deleteById(id);
        }
    }

    @Override
    public Product updateProduct(ProductRequestDto productRequestDto, long id) {
        Product product = getProductById(id);
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());

        return productRepository.save(product);
    }

    @Override
    public List<Review> getReviewsOfProduct(long id) {
        Product product = getProductById(id);
        return reviewRepository.findAllByProduct(product);
    }

    @Override
    public List<Order> getOrdersOfProduct(long id) {
        Product product = getProductById(id);
        return orderRepository.findAllByProduct(product);
    }
}
