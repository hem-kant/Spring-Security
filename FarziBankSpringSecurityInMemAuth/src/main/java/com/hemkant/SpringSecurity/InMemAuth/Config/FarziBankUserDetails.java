package com.hemkant.SpringSecurity.InMemAuth.Config;

import com.hemkant.SpringSecurity.InMemAuth.Model.Customer;
import com.hemkant.SpringSecurity.InMemAuth.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarziBankUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Authenticate user using custom mySQL table
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName,password = null;
        List<GrantedAuthority> authorities=null;
        List<Customer> customer=customerRepository.findByEmail(username);

        if (customer.size() ==0){
            throw  new UsernameNotFoundException("User Details not found for the user: "+ username);
        }else{
            userName =customer.get(0).getEmail();
            password=customer.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return  new User(username,password,authorities);
    }

}
