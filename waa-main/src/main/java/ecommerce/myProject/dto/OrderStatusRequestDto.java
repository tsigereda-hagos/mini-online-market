package ecommerce.myProject.dto;

import ecommerce.myProject.Domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusRequestDto {

    private OrderStatus status;
}
