package com.demo.abcrestaurant.repository;

import com.demo.abcrestaurant.model.ReservationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationOrderRepository extends JpaRepository<ReservationOrder, Long> {

    List<ReservationOrder> findByUserId(Long userId);
}
