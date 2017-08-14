package demo.workshop.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService ; 

	
	@GetMapping("customer/{id}")	
	public Customer getCustomer(@PathVariable Long id) {
		Customer result = customerService.getCustomer(id);
		System.out.println("Ich bin in getCustomer");
		return result ;
	} 
	
	@PostMapping("customer")
	public Long createCustomer(@RequestBody CustomerCreate customerCreate) {
		Customer customer = new Customer(); 
		customer.setName(customerCreate.getName());
		customer.setLastName(customerCreate.getLastName());
		Customer result = customerService.createCustumer(customer);
		return result.getId() ; 
	}
	
	
	@DeleteMapping("customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PutMapping("customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdate customerUpdate) {
		customerService.updateCustomer(id, customerUpdate);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
		
	@GetMapping("test")
	public Customer getTest() {
		return customerService.getDummy();
	}
	
	
	
	
}
