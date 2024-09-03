package com.demo.abcrestaurant.service;

import com.demo.abcrestaurant.dto.OrderItemDTO;
import com.demo.abcrestaurant.model.MenuItem;
import com.demo.abcrestaurant.model.OrderItem;
import com.demo.abcrestaurant.model.ReservationOrder;
import com.demo.abcrestaurant.repository.MenuItemRepository;
import com.demo.abcrestaurant.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public void addOrderItem(OrderItemDTO orderItemDTO, ReservationOrder reservationOrder) {
        MenuItem menuItem = menuItemRepository.findById(orderItemDTO.getMenuItemId())
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setMenuItem(menuItem);
        orderItem.setReservationOrder(reservationOrder);

        orderItemRepository.save(orderItem);
    }
}

