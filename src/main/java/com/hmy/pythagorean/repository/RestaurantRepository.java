package com.hmy.pythagorean.repository;

import com.hmy.pythagorean.entity.RestaurantEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface RestaurantRepository extends ListCrudRepository<RestaurantEntity, Long> {
}
