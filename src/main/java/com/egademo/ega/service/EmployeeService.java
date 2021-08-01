package com.egademo.ega.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egademo.ega.entity.User;
import com.egademo.ega.repos.UserRepository;


@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createEmployee(User emp) {
		// TODO Auto-generated method stub
		User employee = userRepo.save(emp);
		return employee;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getEmpById(Long empL) {
		// TODO Auto-generated method stub
		return userRepo.findById(empL).get();
	}

	@Override
	public void deleteEmpById(Long empL) {
		// TODO Auto-generated method stub
		userRepo.deleteById(empL);
	}
	
}
