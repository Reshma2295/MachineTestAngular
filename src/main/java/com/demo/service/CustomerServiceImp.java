package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.entity.CustomerDetails;
import com.demo.repository.ICustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService {
	
	private ICustomerRepository icustomerRepository;
	
	

	public CustomerServiceImp(ICustomerRepository icustomerRepository) {
		super();
		this.icustomerRepository = icustomerRepository;
	}



	@Override
	public List<CustomerDetails> findAll() {
		return icustomerRepository.findAll();
	}



	@Override
	public CustomerDetails findById(int theId) {
		Optional<CustomerDetails>result=icustomerRepository.findById(theId);

		CustomerDetails theCustomerDetails=null;

		if(result.isPresent()) {

			theCustomerDetails=result.get();

		}

		else {

			throw new RuntimeException("Did not find Customer Id "+theId);

		}

		return theCustomerDetails;

	}


	@Override
	public void save(CustomerDetails theCustomerDetails) {
		icustomerRepository.save(theCustomerDetails);
		
	}



	@Override
	public void deleteById(int theId) {
		icustomerRepository.deleteById(theId);
		
	}

}
