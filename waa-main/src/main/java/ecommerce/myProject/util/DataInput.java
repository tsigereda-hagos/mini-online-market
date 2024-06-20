package ecommerce.myProject.util;
import ecommerce.myProject.Domain.*;
import ecommerce.myProject.Repository.*;
import ecommerce.myProject.Service.BuyerService;
import ecommerce.myProject.Service.ReviewService;
import ecommerce.myProject.Service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DataInput implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired

    private BuyerRepository buyerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    SellerService sellerService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createAdmins();
        createSellers();
        createBuyers();
        createProducts();
        createOrders();
        createReviews();
        createAddress();
    }

    private void createRoles(){
        Role role_Admin = new Role(1,"ROLE_ADMIN", null);
        Role role_Seller = new Role(2,"ROLE_SELLER", null);
        Role role_Buyer = new Role(3,"ROLE_BUYER", null);
        roleRepository.saveAll(Arrays.asList(role_Admin, role_Seller, role_Buyer));
    }

    private void createSellers(){
        Seller seller = new Seller("Adonay Joseph", true, null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findById(2L).get());
        seller.setUsername("adu");
        seller.setPassword(new BCryptPasswordEncoder().encode("1234"));
        seller.setRoles(roleSet);
        sellerRepository.saveAll(Arrays.asList(seller));
    }

    private void createBuyers(){
        Buyer buyer = new Buyer(0,"Joseph Samuel",null,null,null,null,null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findById(3L).get());
        buyer.setUsername("joseph");
        buyer.setPassword(new BCryptPasswordEncoder().encode("1234"));
        buyer.setRoles(roleSet);
        Buyer savedBuyer = buyerRepository.save(buyer);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setBuyer(savedBuyer);
        shoppingCartRepository.save(shoppingCart);

    }

    private void createAdmins(){

        Admin admin1 = new Admin();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findById(1L).get());
        admin1.setUsername("admin");
        admin1.setPassword(new BCryptPasswordEncoder().encode("1234"));
        admin1.setRoles(roleSet);
        adminRepository.save(admin1);

    }

    private void createProducts(){

        Product product2 = new Product(1,"Electronics","Apple product are the most expensive and market dominant products.", 1099, null, null, null);
        Product product1 = new Product(2,"Food","organic products and it's all vegan and we do care about the environment", 29, null, null, null);
        Product product3 = new Product(3,"Cloth","All Brands in one, Gucci, H&M, American Eagle, Adidas, Nike, Puma", 19, null, null, null);
        Product product4 = new Product(4,"House Hold Equipments","We Provide the bes house hold equipments though out the US.", 9, null, null, null);
        Product product5 = new Product(5,"Shoes","We Provide all Shoe Brands such as Adidas, Nike, Skechers", 49, null, null, null);
        Product product6 = new Product(6,"Cosmetics","We Provide the bes house hold equipments though out the US.", 11, null, null, null);


        sellerService.addProduct(product1, 5L);
        sellerService.addProduct(product2, 5L);
        sellerService.addProduct(product3, 5L);
        sellerService.addProduct(product4, 5L);
        sellerService.addProduct(product5, 5L);
        sellerService.addProduct(product6, 5L);
    }

    private void createOrders(){
        Optional<Product> product1 = productRepository.findById(8L);
        Optional<Buyer> buyer1 = buyerRepository.findById(6L);
        Order order = new Order();
        order.setStatus(OrderStatus.ORDERED);
        order.setProduct(product1.get());
        order.setBuyer(buyer1.get());
        orderRepository.save(order);
    }

    private void createReviews(){
//        Review review1 = new Review();
//        review1.setContent("I have enjoyed this product, I hope everyone do so.");
//        buyerService.addReviewByBuyerId(review1,6, 8);
    }

    private void createAddress(){
        Address address1 = new Address();
        address1.setAddressType(AddressType.SHIPPING);
        address1.setCountry("USA");
        address1.setCity("Fairfield");
        address1.setState("Iowa");
        address1.setZipCode(52557);
        buyerService.addAddressToBuyer(address1,6);

        Address address2 = new Address();
        address2.setAddressType(AddressType.BILLING);
        address2.setCountry("ER");
        address2.setCity("Asmara");
        address2.setState("Maekel");
        address2.setZipCode(00000);
        buyerService.addAddressToBuyer(address2,6);
    }

}
