package com.egademo.ega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egademo.ega.entity.User;
import com.egademo.ega.service.EmployeeServiceInterface;


@RestController
@RequestMapping("/code")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface empServiceInnc;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("getAll")
	public List<User> getEmployee(){
		return empServiceInnc.findAll();
	}
	
	@GetMapping("emp/{empId}")
	public ResponseEntity<User> getEmpbyId(@PathVariable("empId") Long empL){
		User emp = empServiceInnc.getEmpById(empL);
		return new ResponseEntity<User>(emp , HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{empId}")
	public ResponseEntity<Void> deleteEmpbyId(@PathVariable("empId") Long empL){
		empServiceInnc.deleteEmpById(empL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@PutMapping("updateEmp")
	public ResponseEntity<User> updateEmployee(@RequestBody User employee){
		User emp = empServiceInnc.createEmployee(employee);
		return new ResponseEntity<User>(emp , HttpStatus.CREATED);
	}
}
