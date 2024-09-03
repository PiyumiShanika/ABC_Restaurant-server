package com.demo.abcrestaurant.dto;

import com.demo.abcrestaurant.model.ReservationOrder;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationOrderDTO {

    private Long id;
    private LocalDateTime dateTime;
    private ReservationOrder.OrderType type;
    private String status;
    private String guestName;
    private String guestEmail;
    private String guestPhone;
    private int numberOfPeople;
    private Long userId;
    private List<OrderItemDTO> orderItems;

    public ReservationOrderDTO(LocalDateTime dateTime, ReservationOrder.OrderType type, String status, String guestName, String guestEmail, String guestPhone, int numberOfPeople, Long userId, List<OrderItemDTO> orderItems, Long id) {
        this.dateTime = dateTime;
        this.type = type;
        this.status = status;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.guestPhone = guestPhone;
        this.numberOfPeople = numberOfPeople;
        this.userId = userId;
        this.orderItems = orderItems;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ReservationOrder.OrderType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = ReservationOrder.OrderType.valueOf(type);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
