package com.demo.abcrestaurant.repository;

import com.demo.abcrestaurant.model.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    MenuCategory findByName(String name);

}