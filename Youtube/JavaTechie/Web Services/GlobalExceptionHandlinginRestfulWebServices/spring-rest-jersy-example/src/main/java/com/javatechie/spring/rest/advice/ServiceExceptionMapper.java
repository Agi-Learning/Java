package com.javatechie.spring.rest.advice;

import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.http.HttpStatus;

import com.javatechie.spring.rest.api.dto.ErrorMessage;


public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

	@Override
	public Response toResponse(ServiceException exception) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(exception.getMessage());
		errorMessage.setErrorCode(exception.getStatusCode());
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new java.io.PrintWriter(sw));
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
	}

}
