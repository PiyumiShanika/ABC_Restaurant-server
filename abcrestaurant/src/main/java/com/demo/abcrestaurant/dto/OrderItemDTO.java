package com.demo.abcrestaurant.dto;

import com.demo.abcrestaurant.model.MenuItem;

public class OrderItemDTO {

    private Long id;
    private int quantity;
    private Long menuItemId;

    public OrderItemDTO(Long id, int quantity, Long menuItemId) {
        this.id = id;
        this.quantity = quantity;
        this.menuItemId = menuItemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }
}
