package com.hmy.pythagorean.service;

import com.hmy.pythagorean.entity.CartEntity;
import com.hmy.pythagorean.entity.CustomerEntity;
import com.hmy.pythagorean.repository.CartRepository;
import com.hmy.pythagorean.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsManager userDetailsManager;

    public CustomerService(CartRepository cartRepository, CustomerRepository customerRepository, PasswordEncoder passwordEncoder, UserDetailsManager userDetailsManager) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsManager = userDetailsManager;
    }

    @Transactional
    public void signUp(String email, String password, String firstName, String lastName) {
        // create user using spring security
        email = email.toLowerCase();
        UserDetails user = User.builder()
                .username(email)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);
        // update first last name
        customerRepository.updateNameByEmail(email, firstName, lastName);

        // create 1:1 shopping cart
        CustomerEntity savedCustomer = customerRepository.findByEmail(email);
        CartEntity cart = new CartEntity(null, savedCustomer.id(), 0.0);
        cartRepository.save(cart);
    }

    public CustomerEntity getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
