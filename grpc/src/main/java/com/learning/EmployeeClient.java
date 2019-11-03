package com.learning;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Component
public class EmployeeClient {
	private EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
	
	@PostConstruct
	  private void init() {
	    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

	    blockingStub =
	    		EmployeeServiceGrpc.newBlockingStub(managedChannel);
	    
	}

	  public String getEmployee() {
	    Employee emp = Employee.newBuilder().setName("Anshu").setAge(31).setDateOfBirth("8 Oct")
	        .setDepartment("DI").build();
	    System.out.println("client sending {}"+emp.toString());

	    EmployeeRespnse res =
	    		blockingStub.getEmployee(emp);
	      System.out.println("client received {}"+emp.toString());

	        return res.getMessage();
}
}
