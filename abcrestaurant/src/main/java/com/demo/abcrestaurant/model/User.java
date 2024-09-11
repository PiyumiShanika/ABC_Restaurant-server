package com.demo.abcrestaurant.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN, STAFF, CUSTOMER

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ReservationOrder> reservationOrders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<ReservationOrder> getReservationOrders() {
        return reservationOrders;
    }

    public void setReservationOrders(Set<ReservationOrder> reservationOrders) {
        this.reservationOrders = reservationOrders;
    }

    public enum Role {
        ADMIN, STAFF, CUSTOMER;
    }
}

