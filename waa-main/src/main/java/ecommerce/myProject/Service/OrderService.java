package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Order;


public interface OrderService {

    Order findOrderById(long id);

    Order cancelOrder(long orderId);

    Order shipOrder(long orderId);

    Order deliverOrder(long orderId);
}
