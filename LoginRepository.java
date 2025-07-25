package com.artapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artapp.model.Login;

public interface LoginRepository extends JpaRepository<Login, String>{
	Login findByEmailIdAndPassword(String emailId, String password);
}
