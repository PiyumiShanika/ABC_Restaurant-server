package com.demo.abcrestaurant.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservationOrderDTO {

    private Long id;
    private String date;
    private String time;
    private String type;
    private String status;
    private String guestName;
    private String guestEmail;
    private String guestPhone;
    private int numberOfPeople;
    private List<OrderItemDTO> orderItems;

    public ReservationOrderDTO(LocalDate date, LocalTime time, String type, String status, String guestName, String guestEmail, String guestPhone, int numberOfPeople, List<OrderItemDTO> orderItems, Long id) {
        this.date = String.valueOf(date);
        this.time = String.valueOf(time);
        this.type = type;
        this.status = status;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.guestPhone = guestPhone;
        this.numberOfPeople = numberOfPeople;
        this.orderItems = orderItems;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = String.valueOf(date);
    }

    public String getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = String.valueOf(time);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
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

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
