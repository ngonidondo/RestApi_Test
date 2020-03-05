package com.trial.t3.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.trial.t3.object.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findAll();
	Employee findById(int id);
	Optional<Employee> findOptById(int id);
}
