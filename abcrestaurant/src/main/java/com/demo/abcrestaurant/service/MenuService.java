package com.demo.abcrestaurant.service;

import com.demo.abcrestaurant.dto.MenuCategoryDTO;
import com.demo.abcrestaurant.dto.MenuItemDTO;
import com.demo.abcrestaurant.model.MenuCategory;
import com.demo.abcrestaurant.model.MenuItem;
import com.demo.abcrestaurant.repository.MenuCategoryRepository;
import com.demo.abcrestaurant.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public List<MenuCategoryDTO> getAllCategoriesWithItems() {
        return menuCategoryRepository.findAll().stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    public MenuItemDTO addMenuItem(MenuItemDTO menuItemDTO) {
        MenuCategory category = menuCategoryRepository.findByName(menuItemDTO.getCategoryName());
        if (category == null) {
            category = new MenuCategory(menuItemDTO.getCategoryName());
            menuCategoryRepository.save(category);
        }

        MenuItem menuItem = new MenuItem(
                menuItemDTO.getName(),
                menuItemDTO.getPrice(),
                menuItemDTO.getDescription(),
                category
        );

        menuItem = menuItemRepository.save(menuItem);
        return convertToItemDTO(menuItem);
    }

    public MenuItemDTO updateMenuItem(Long id, MenuItemDTO menuItemDTO) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("MenuItem not found"));
        menuItem.setName(menuItemDTO.getName());
        menuItem.setPrice(menuItemDTO.getPrice());
        menuItem.setDescription(menuItemDTO.getDescription());

        MenuCategory category = menuCategoryRepository.findByName(menuItemDTO.getCategoryName());
        if (category == null) {
            category = new MenuCategory(menuItemDTO.getCategoryName());
            menuCategoryRepository.save(category);
        }

        menuItem.setMenuCategory(category);
        menuItem = menuItemRepository.save(menuItem);

        return convertToItemDTO(menuItem);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    private MenuItemDTO convertToItemDTO(MenuItem menuItem) {
        return new MenuItemDTO(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.getDescription(),
                menuItem.getMenuCategory().getName()
        );
    }

    private MenuCategoryDTO convertToCategoryDTO(MenuCategory category) {
        List<MenuItemDTO> items = category.getMenuItems().stream()
                .map(this::convertToItemDTO)
                .collect(Collectors.toList());

        return new MenuCategoryDTO(
                category.getId(),
                category.getName(),
                items
        );
    }
}

