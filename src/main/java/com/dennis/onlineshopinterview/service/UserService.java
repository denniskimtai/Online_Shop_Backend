package com.dennis.onlineshopinterview.service;

import com.dennis.onlineshopinterview.api.model.Registration;
import com.dennis.onlineshopinterview.exception.UserExistsException;
import com.dennis.onlineshopinterview.model.Customer;
import com.dennis.onlineshopinterview.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Customer registerUser(Registration registration) throws UserExistsException {

        if(userRepository.findByEmailIgnoreCase(registration.getEmailAddress()).isPresent()){
            throw new UserExistsException();
        }
        Customer customer = new Customer();
        customer.setFirstName(registration.getFirstName());
        customer.setLastName(registration.getLastName());
        customer.setEmail(registration.getEmailAddress());
        //TODO: Hash password
        customer.setPasswordHash(registration.getPassword());
        return userRepository.save(customer);

    }
}
