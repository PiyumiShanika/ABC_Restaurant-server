package com.demo.abcrestaurant.dto;

import java.util.List;

public class MenuCategoryDTO {

    private Long id;
    private String name;
    private List<MenuItemDTO> menuItems;

    public MenuCategoryDTO() {}

    public MenuCategoryDTO(String name) {
        this.name = name;
    }

    public MenuCategoryDTO(Long id, String name, List<MenuItemDTO> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }
}

