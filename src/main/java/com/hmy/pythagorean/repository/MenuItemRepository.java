package com.hmy.pythagorean.repository;

import com.hmy.pythagorean.entity.MenuItemEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface MenuItemRepository extends ListCrudRepository<MenuItemEntity, Long> {
    List<MenuItemEntity> getByRestaurantId(Long RestaurantId);
}
