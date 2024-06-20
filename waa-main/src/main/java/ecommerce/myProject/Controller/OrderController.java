package ecommerce.myProject.Controller;

import ecommerce.myProject.Domain.Order;
import ecommerce.myProject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PatchMapping("/orders/{orderId}/cancel")
    public Order cancelOrder(@PathVariable long orderId){
        return orderService.cancelOrder(orderId);
    }

    @PatchMapping("/orders/{orderId}/ship")
    public Order shipOrder(@PathVariable long orderId){
        return orderService.shipOrder(orderId);
    }

    @PatchMapping("/orders/{orderId}/deliver")
    public Order deliverOrder(@PathVariable long orderId){
        return orderService.deliverOrder(orderId);
    }
}
