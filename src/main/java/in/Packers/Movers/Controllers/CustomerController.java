package in.Packers.Movers.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Packers.Movers.Entity.customerEntity;
import in.Packers.Movers.Services.CustomerService;
import in.Packers.Movers.Services.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody customerEntity customer) {
		customerService.addCustomer(customer);
		return ResponseEntity.ok("Customer registered successfully");
	}
}
