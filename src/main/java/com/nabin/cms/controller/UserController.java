package com.nabin.cms.controller;

import com.nabin.cms.dto.UserDto;
import com.nabin.cms.model.Address;
import com.nabin.cms.model.User;
import com.nabin.cms.repository.UserRepository;
import com.nabin.cms.service.AddressService;
import com.nabin.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nabin
 */
//public class UserController {
//}
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        System.out.println("****");
        System.out.println(userDto);
        System.out.println(userDto.getUsername());
        User user = new User();
        user.setUsername(userDto.getUsername());
        // Save the user
        User savedUser = userService.createUser(user);

        if (savedUser != null && userDto.getAddress() != null) {
            Address address = new Address();
            address.setStreet(userDto.getAddress().getStreet());
            address.setCity(userDto.getAddress().getCity());
            address.setZipCode(userDto.getAddress().getZipCode());

            // Set the user to the address
            address.setUser(savedUser);

            // Save the address
            addressService.createAddress(address);

            // Update the user with the saved address
//            savedUser.setAddresses(List.of(address));

            // Return the updated user
            return userService.updateUser(savedUser);
        }

        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User existingUser = userService.getUserById(id);

        if (existingUser != null) {
            existingUser.setUsername(userDto.getUsername());

            if (userDto.getAddress() != null) {
                Address existingAddress = new Address();
                existingAddress.setStreet(userDto.getAddress().getStreet());
                existingAddress.setCity(userDto.getAddress().getCity());
                existingAddress.setZipCode(userDto.getAddress().getZipCode());
                existingAddress.setUser(existingUser);
                addressService.createAddress(existingAddress);
                existingUser.setAddresses(List.of(existingAddress));
            }

            return userService.updateUser(existingUser);
        } else {
            // Handle the case when the user with the specified ID is not found
            // You might want to return an error response or throw an exception
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}