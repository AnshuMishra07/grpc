package com.learning.grpc;

import org.lognet.springboot.grpc.GRpcService;

import com.learning.Employee;
import com.learning.EmployeeRespnse;
import com.learning.EmployeeServiceGrpc.EmployeeServiceImplBase;

import io.grpc.stub.StreamObserver;
@GRpcService
public class EmployeeServiceImpl extends EmployeeServiceImplBase {
	@Override
	public void getEmployee(Employee request, StreamObserver<EmployeeRespnse> responseObserver) {
		 System.out.println("server received -------" + request.getName()+request.getDepartment());

		 String message = "Hello " + request.getName()+ "!";
			    EmployeeRespnse response =
			    		EmployeeRespnse.newBuilder().setMessage(message).build();
			    System.out.println("server responded -------" + response);

			    responseObserver.onNext(response);
			    responseObserver.onCompleted();
	}

}
