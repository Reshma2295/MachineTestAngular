package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.CustomerDetails;
import com.demo.service.ICustomerService;

@CrossOrigin

@RestController

@RequestMapping("/api")
public class CustomerController {
	
	private ICustomerService iCustomerService ;

	@Autowired
	public CustomerController(ICustomerService iCustomerService) {
		super();
		this.iCustomerService = iCustomerService;
	}
	
	@GetMapping("/customers")

	public List<CustomerDetails> findAll() {

		return iCustomerService.findAll();

	}
	
	@GetMapping("/customers/{custNo}")

	public CustomerDetails getCustomer(@PathVariable int custNo) {

		CustomerDetails thecustomerDetails = iCustomerService.findById(custNo);

		if (thecustomerDetails == null) {

			throw new RuntimeException("Customer id not found-" + custNo);

		}

		return thecustomerDetails;

	}

	@PostMapping("/customers")

	public CustomerDetails addCustomers(@RequestBody CustomerDetails thecustomerDetails) {

		thecustomerDetails.setCustNo(0);

		iCustomerService.save(thecustomerDetails);

		return thecustomerDetails;

	}
	

	@DeleteMapping("/customers/{custNo}")

	public String deleteCustomer(@PathVariable int custNo) {

		CustomerDetails thecustomerDetails = iCustomerService.findById(custNo);

		if (thecustomerDetails == null) {

			throw new RuntimeException("Customer id not found-" + custNo);

		}

		iCustomerService.deleteById(custNo);

		return "Deleted patientid: " + custNo;

	}

	

}
