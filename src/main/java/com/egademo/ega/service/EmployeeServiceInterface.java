package com.egademo.ega.service;

import java.util.List;

import com.egademo.ega.entity.User;

public interface EmployeeServiceInterface {

	public User createEmployee(User emp);

	public List<User> findAll();

	public User getEmpById(Long empL);

	public void deleteEmpById(Long empL);

//	public List<User> getAllUsers();

}
