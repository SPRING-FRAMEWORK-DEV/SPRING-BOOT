package com.ahlo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseSender {

	private  AhloResponse buildSuccessResponse(Object[] data)
	{
		AhloResponse ahloResponse=new AhloResponse();
		ahloResponse.data=data;
		ahloResponse.serviceStatus=ServiceStatus.SUCCESS;
		return ahloResponse;
	}
	
	public  ResponseEntity<Object> sendResponse(Object[] data) 
	{
			return new ResponseEntity<>(buildSuccessResponse(data),HttpStatus.OK);
	}
	
	
}