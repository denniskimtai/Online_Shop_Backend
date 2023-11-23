package com.dennis.onlineshopinterview.repository;

import com.dennis.onlineshopinterview.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<Customer, UUID> {
    Optional<Customer> findByEmailIgnoreCase(String email);


}
