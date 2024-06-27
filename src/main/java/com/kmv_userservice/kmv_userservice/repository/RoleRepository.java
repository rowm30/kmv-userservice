package com.kmv_userservice.kmv_userservice.repository;

import com.kmv_userservice.kmv_userservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}