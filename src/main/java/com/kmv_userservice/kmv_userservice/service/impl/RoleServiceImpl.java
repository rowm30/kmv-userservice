package com.kmv_userservice.kmv_userservice.service.impl;


import com.kmv_userservice.kmv_userservice.models.Role;
import com.kmv_userservice.kmv_userservice.repository.RoleRepository;
import com.kmv_userservice.kmv_userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        System.out.println("Saving role with name: " + role.getRoleName());
        if (role.getRoleName() == null) {
            System.out.println("Role name is null!");
        }
        return roleRepository.save(role);
    }
}