package com.sunil__parcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil__parcha.modal.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
