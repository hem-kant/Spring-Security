package com.hemkant.SpringSecurity.InMemAuth.Repository;

import com.hemkant.SpringSecurity.InMemAuth.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findByEmail(String email);
}
