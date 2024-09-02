package com.demo.abcrestaurant.repository;

import com.demo.abcrestaurant.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByMenuCategoryId(Long categoryId);

    List<MenuItem> findByNameContaining(String name);

}
