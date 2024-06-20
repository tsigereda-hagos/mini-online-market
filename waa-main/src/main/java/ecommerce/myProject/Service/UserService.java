package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.User;
import ecommerce.myProject.dto.UserAvailabilityRequestDto;


public interface UserService {

    User getUserByUsername(String username);

    Iterable<User> getAllUsers();

    User getUserById(long id);

    User addUser(User user);

    void deleteUser(long id);

    User isUsernameAvailable(UserAvailabilityRequestDto userAvailabilityRequestDto);

}
