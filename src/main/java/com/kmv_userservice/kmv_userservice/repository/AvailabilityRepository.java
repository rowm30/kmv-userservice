package com.kmv_userservice.kmv_userservice.repository;

import com.kmv_userservice.kmv_userservice.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
}
