package com.demo.abcrestaurant.service;

import com.demo.abcrestaurant.dto.OrderItemDTO;
import com.demo.abcrestaurant.dto.ReservationOrderDTO;
import com.demo.abcrestaurant.model.OrderItem;
import com.demo.abcrestaurant.model.ReservationOrder;
import com.demo.abcrestaurant.repository.ReservationOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationOrderService {

    @Autowired
    private ReservationOrderRepository reservationOrderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Transactional
    public ReservationOrderDTO createReservation(ReservationOrderDTO reservationOrderDTO) {
        ReservationOrder reservationOrder = new ReservationOrder();
        reservationOrder.setDate(LocalDate.parse(reservationOrderDTO.getDate()));
        reservationOrder.setTime(LocalTime.parse(reservationOrderDTO.getTime()));
        reservationOrder.setType(ReservationOrder.OrderType.valueOf(reservationOrderDTO.getType()));
        reservationOrder.setStatus(ReservationOrder.OrderStatus.PENDING);
        reservationOrder.setGuestName(reservationOrderDTO.getGuestName());
        reservationOrder.setGuestEmail(reservationOrderDTO.getGuestEmail());
        reservationOrder.setGuestPhone(reservationOrderDTO.getGuestPhone());
        reservationOrder.setNumberOfPeople(reservationOrderDTO.getNumberOfPeople());

        reservationOrder = reservationOrderRepository.save(reservationOrder);

        if (reservationOrderDTO.getOrderItems() != null) {
            ReservationOrder finalReservationOrder = reservationOrder;
            reservationOrderDTO.getOrderItems().forEach(orderItemDTO -> {
                orderItemService.addOrderItem(orderItemDTO, finalReservationOrder);
            });
        }

        reservationOrderDTO.setId(reservationOrder.getId());
        return reservationOrderDTO;
    }

    public List<ReservationOrderDTO> getReservationsByUserId(Long userId) {
        List<ReservationOrder> reservations = reservationOrderRepository.findByUserId(userId);
        return reservations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ReservationOrderDTO convertToDTO(ReservationOrder reservationOrder) {
        List<OrderItemDTO> orderItems = reservationOrder.getOrderItems().stream()
                .map(this::convertToOrderItemDTO)
                .collect(Collectors.toList());
        return new ReservationOrderDTO(reservationOrder.getDate(),
                reservationOrder.getTime(),
                reservationOrder.getType().name(),
                reservationOrder.getStatus().name(),
                reservationOrder.getGuestName(),
                reservationOrder.getGuestEmail(),
                reservationOrder.getGuestPhone(),
                reservationOrder.getNumberOfPeople(),
                orderItems,
                reservationOrder.getId());
    }

    private OrderItemDTO convertToOrderItemDTO(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getId(),
                orderItem.getQuantity(),
                orderItem.getMenuItem().getId()
        );
    }

    public ReservationOrderDTO updateReservation(ReservationOrderDTO reservationOrderDTO) {
        ReservationOrder reservationOrder = new ReservationOrder();
        reservationOrder.setDate(LocalDate.parse(reservationOrderDTO.getDate()));
        reservationOrder.setTime(LocalTime.parse(reservationOrderDTO.getTime()));
        reservationOrder.setType(ReservationOrder.OrderType.valueOf(reservationOrderDTO.getType()));
        reservationOrder.setStatus(ReservationOrder.OrderStatus.COMPLETED);
        reservationOrder.setGuestName(reservationOrderDTO.getGuestName());
        reservationOrder.setGuestEmail(reservationOrderDTO.getGuestEmail());
        reservationOrder.setGuestPhone(reservationOrderDTO.getGuestPhone());
        reservationOrder.setNumberOfPeople(reservationOrderDTO.getNumberOfPeople());

        reservationOrder = reservationOrderRepository.save(reservationOrder);

        if (reservationOrderDTO.getOrderItems() != null) {
            ReservationOrder finalReservationOrder = reservationOrder;
            reservationOrderDTO.getOrderItems().forEach(orderItemDTO -> {
                orderItemService.addOrderItem(orderItemDTO, finalReservationOrder);
            });
        }

        reservationOrderDTO.setId(reservationOrder.getId());
        return reservationOrderDTO;
    }

    public List<ReservationOrderDTO> getAllReservations() {
        List<ReservationOrder> reservations = reservationOrderRepository.findAll();
        return reservations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
