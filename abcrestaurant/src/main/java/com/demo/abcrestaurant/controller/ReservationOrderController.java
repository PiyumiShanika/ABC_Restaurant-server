package com.demo.abcrestaurant.controller;

import com.demo.abcrestaurant.dto.ReservationOrderDTO;
import com.demo.abcrestaurant.service.ReservationOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationOrderController {

    @Autowired
    private ReservationOrderService reservationOrderService;

    @PostMapping
    public ResponseEntity<ReservationOrderDTO> createReservation(@RequestBody ReservationOrderDTO reservationOrderDTO) {
        return ResponseEntity.ok(reservationOrderService.createReservation(reservationOrderDTO));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationOrderDTO>> getReservationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(reservationOrderService.getReservationsByUserId(userId));
    }
}
