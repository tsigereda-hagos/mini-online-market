package ecommerce.myProject.Controller;

import ecommerce.myProject.Domain.Order;
import ecommerce.myProject.Domain.Product;
import ecommerce.myProject.Domain.Review;
import ecommerce.myProject.Service.ProductService;
import ecommerce.myProject.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable long id){
        return productService.updateProduct(productRequestDto, id);
    }

    @GetMapping("/products/{id}/reviews")
    public List<Review> getReviewsOfProduct(@PathVariable long id){
        return productService.getReviewsOfProduct(id);
    }

    @GetMapping("products/{id}/orders")
    public List<Order> getOrdersOfProduct(@PathVariable long id){
        return productService.getOrdersOfProduct(id);
    }
}
