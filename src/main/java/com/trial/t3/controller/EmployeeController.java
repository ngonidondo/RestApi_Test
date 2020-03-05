package com.trial.t3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trial.t3.object.Employee;
import com.trial.t3.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("list")
	public List<Employee> retrieveAllEmployees() {
		return empRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Employee retrieveEmployee(@PathVariable int id) {
		return empRepo.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Object> createEmployee(@RequestBody Employee e) {		
		empRepo.save(e);

		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		Optional<Employee> empOpt = empRepo.findOptById(id);
		if (!empOpt.isPresent())
			return ResponseEntity.notFound().build();

		e.setId(id);
		
		empRepo.save(e);

		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable int id) {
		empRepo.deleteById(id);
	}
}
