package com.sunil__parcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil__parcha.modal.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

	public Role findById(int i);

}
