package com.nabin.cms.service;

import com.nabin.cms.dto.AddressDto;
import com.nabin.cms.model.Address;
import com.nabin.cms.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nabin
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.orElse(null);
    }

    public Address createAddress(Address address) {
        // You might want to perform additional validation or business logic here
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        // You might want to perform additional validation or business logic here
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        // You might want to check if the address exists before deleting
        addressRepository.deleteById(id);
    }

    // Other methods as needed
}