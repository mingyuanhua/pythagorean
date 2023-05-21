package com.hmy.pythagorean.repository;

import com.hmy.pythagorean.entity.CustomerEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByFirstName(String firstName);
    List<CustomerEntity> fingByLastName(String lastName);
    CustomerEntity findByEmail(String email);

    @Modifying
    @Query("UPDATE customers SET first_name = :firstName, last_name = : lastName WHERE email := email")
    void updateNameByEmail(String email, String firstName, String lastName);
}
