package com.dennis.onlineshopinterview.service;

import com.dennis.onlineshopinterview.api.model.LoginRequest;
import com.dennis.onlineshopinterview.api.model.RegistrationRequest;
import com.dennis.onlineshopinterview.exception.UserExistsException;
import com.dennis.onlineshopinterview.model.Customer;
import com.dennis.onlineshopinterview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    EncryptionService encryptionService;
    @Autowired
    JWTService jwtService;

    public Customer registerUser(RegistrationRequest registrationRequest) throws UserExistsException {

        if(userRepository.findByEmailIgnoreCase(registrationRequest.getEmailAddress()).isPresent()){
            throw new UserExistsException();
        }
        Customer customer = new Customer();
        customer.setFirstName(registrationRequest.getFirstName());
        customer.setLastName(registrationRequest.getLastName());
        customer.setEmail(registrationRequest.getEmailAddress());
        //TODO: Hash password
        customer.setPasswordHash(encryptionService.encryptPassword(registrationRequest.getPassword()));
        return userRepository.save(customer);

    }

    public String loginUser(LoginRequest loginRequest){
        Optional<Customer> optionalCustomer = userRepository.findByEmailIgnoreCase(loginRequest.getEmail());

        if(!optionalCustomer.isPresent()){
            return null;
        }
        Customer customer = optionalCustomer.get();
        if(!encryptionService.verifyPassword(loginRequest.getPassword(), customer.getPasswordHash())){
            return null;
        }

        return jwtService.generateJWT(customer);
    }
}
