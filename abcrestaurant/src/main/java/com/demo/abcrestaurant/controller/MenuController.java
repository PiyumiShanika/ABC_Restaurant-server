package com.demo.abcrestaurant.controller;

import com.demo.abcrestaurant.dto.MenuCategoryDTO;
import com.demo.abcrestaurant.dto.MenuItemDTO;
import com.demo.abcrestaurant.dto.ReservationOrderDTO;
import com.demo.abcrestaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/categories")
    public ResponseEntity<List<MenuCategoryDTO>> getAllCategoriesWithItems() {
        return ResponseEntity.ok(menuService.getAllCategoriesWithItems());
    }

    @PostMapping("/item")
    public ResponseEntity<MenuItemDTO> addMenuItem(@RequestBody MenuItemDTO menuItemDTO) {
        return ResponseEntity.ok(menuService.addMenuItem(menuItemDTO));
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<MenuItemDTO> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemDTO menuItemDTO) {
        return ResponseEntity.ok(menuService.updateMenuItem(id, menuItemDTO));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
}