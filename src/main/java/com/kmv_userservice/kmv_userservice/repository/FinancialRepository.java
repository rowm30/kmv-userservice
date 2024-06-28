package com.kmv_userservice.kmv_userservice.repository;

import com.kmv_userservice.kmv_userservice.models.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<Financial, Integer> {
}
