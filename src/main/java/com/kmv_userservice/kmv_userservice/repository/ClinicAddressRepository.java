package com.kmv_userservice.kmv_userservice.repository;

import com.kmv_userservice.kmv_userservice.models.ClinicAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicAddressRepository extends JpaRepository<ClinicAddress, Long> {
}
