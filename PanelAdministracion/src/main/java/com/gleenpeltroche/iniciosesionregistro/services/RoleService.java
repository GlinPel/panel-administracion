package com.gleenpeltroche.iniciosesionregistro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gleenpeltroche.iniciosesionregistro.models.Role;
import com.gleenpeltroche.iniciosesionregistro.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findRoleAdmin() {
		return roleRepository.findByName("ROLE_ADMIN");
	}
	
	public List<Role> findRoleUser() {
		return roleRepository.findByName("ROLE_USER");
	}
}
