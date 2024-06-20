package ecommerce.myProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequestDto {

    private String username;
    private String password;
    private String fullName;
    private boolean isBuyer;
    private boolean isSeller;
}
