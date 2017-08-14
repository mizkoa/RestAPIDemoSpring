package demo.workshop.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {
					
	
	@Autowired
	CustomerRepo customerRepo ; 
	
	Customer customerObj = new Customer(); 
	
	public Customer getCustomer(Long id) {
		return (Customer) customerRepo.findOne(id); 
		
	}
	
	public Customer createCustumer(Customer customer) {
		return (Customer) customerRepo.save(customer) ;
		
	}
		
	public void deleteCustomer(Long id) {
		customerRepo.delete(id);
	}
	
	public void updateCustomer(Long id, CustomerUpdate customerUpdate){
		customerObj = customerRepo.findOne(id); 
		customerObj.setName(customerUpdate.getName());
		customerObj.setLastName(customerUpdate.getLastName());
		customerRepo.save(customerObj) ; 
	}
	
	public Customer getDummy() {
		customerObj.setName("James");
		customerObj.setLastName("Brown");
		return  customerObj ;
		
	}
	
	/* testing other shiet */
	public Customer getCustomer3(Long id) {
		Customer result = customerRepo.getOne(id);
		Customer otherResult = new Customer(); 
		otherResult.setName(result.getName()); 
		otherResult.setLastName(result.getLastName());		
		return otherResult ; 
		
	}
	
	public Customer getCustomer2(Long id ) throws CloneNotSupportedException {	
		Customer result ; 
		System.out.println("ich bin da");
		result = customerRepo.getOne(id) ;
		System.out.println(String.format("name %s phone %s id %s", result.getName(), result.getLastName(), result.getId() ));
		Customer other = (Customer) result.clone() ;
		return other ; 
	}



}
