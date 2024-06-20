package ecommerce.myProject.dto;

import ecommerce.myProject.Domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddressDto {

    private Address shippingAddress;
    private Address billingAddress;
}
