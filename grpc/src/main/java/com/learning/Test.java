package com.learning;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Test {
	@Autowired
	EmployeeClient client;
	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
		
		
	}
	@PostConstruct
	private void test() {
		client.getEmployee();
	}
	

}
