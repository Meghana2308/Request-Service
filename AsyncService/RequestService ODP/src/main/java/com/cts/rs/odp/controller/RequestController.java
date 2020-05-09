package com.cts.rs.odp.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rs.odp.model.Request;
import com.cts.rs.odp.service.RequestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value ="RequestController",description="Request controller for request to donor")
public class RequestController {
	@Autowired
	public RequestService requestservice;
	@ApiOperation(value="Post all request",
			  produces="A list of request",
			  notes="Hit this URL to get all request details"
			  )

	@PostMapping("/request")
    public void addProduct(@RequestBody Request product) {
        requestservice.saveproduct(product);    
    }
	
	@RequestMapping("request/{requestId}")
	public Optional<Request> getById( @PathVariable int requestId) {
		return requestservice.getrequestById(requestId);
		
	}
}







