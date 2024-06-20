package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Order;
import ecommerce.myProject.Domain.OrderStatus;
import ecommerce.myProject.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order findOrderById(long id){
        return orderRepository.findById(id).get();
    }

    @Override
    public Order cancelOrder(long orderId) {
        Order order = findOrderById(orderId);
        if(order.getStatus() == OrderStatus.ORDERED){
            order.setStatus(OrderStatus.CANCELLED);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order shipOrder(long orderId) {
        Order order = findOrderById(orderId);
        if (order.getStatus() == OrderStatus.ORDERED){
            order.setStatus(OrderStatus.SHIPPED);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order deliverOrder(long orderId) {
        Order order = findOrderById(orderId);
        if (order.getStatus() == OrderStatus.SHIPPED){
            order.setStatus(OrderStatus.DELIVERED);
        }
        return orderRepository.save(order);
    }
}
