package ecommerce.myProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum OrderStatus {

    ORDERED("Ordered"), SHIPPED("Shipped"), CANCELLED("Cancelled"), DELIVERED("Delivered");

    private String status;

}
