package com.demo.abcrestaurant.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "menuCategory", cascade = CascadeType.ALL)
    private Set<MenuItem> menuItems;

    public MenuCategory() {
    }

    public MenuCategory(String categoryName) {
        this.name = categoryName;
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

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}

