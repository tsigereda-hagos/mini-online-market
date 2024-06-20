package ecommerce.myProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum AddressType {

    BILLING("BILLING"), SHIPPING("SHIPPING");

    private String type;

}
