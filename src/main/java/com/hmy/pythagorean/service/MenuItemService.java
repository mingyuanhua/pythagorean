package com.hmy.pythagorean.service;

import com.hmy.pythagorean.entity.MenuItemEntity;
import com.hmy.pythagorean.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItemEntity> getMenuItemsByRestaurantId(long restaurantId) {
        return menuItemRepository.getByRestaurantId((restaurantId));
    }

    public MenuItemEntity getMenuItemById(long id) {
        return menuItemRepository.findById(id).get();
    }
}
