package com.kmv_userservice.kmv_userservice.repository;

import com.kmv_userservice.kmv_userservice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
