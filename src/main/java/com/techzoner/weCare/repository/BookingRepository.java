package com.techzoner.weCare.repository;

import com.techzoner.weCare.utilites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    public List<Booking> findByCoachId(String coachId);
    public List<Booking> findByUserId(String userId);
}
