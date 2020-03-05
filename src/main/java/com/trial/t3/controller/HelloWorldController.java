package com.trial.t3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

	

	
	@RequestMapping("/")
    public String getEmployees() 
    {
		String helloWorld ="hello";
		return helloWorld;
    }
	
	
}
