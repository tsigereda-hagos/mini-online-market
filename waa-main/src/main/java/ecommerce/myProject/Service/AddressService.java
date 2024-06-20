package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Address;
import ecommerce.myProject.dto.AddressDto;


public interface AddressService {

    void deleteAddress(long id);

    Address updateAddress(AddressDto addressDto, long id);
}
