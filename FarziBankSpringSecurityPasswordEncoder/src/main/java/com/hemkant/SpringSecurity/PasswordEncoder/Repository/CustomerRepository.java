package com.hemkant.SpringSecurity.PasswordEncoder.Repository;

import com.hemkant.SpringSecurity.PasswordEncoder.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByEmail(String email);
}
