
package in.project.controllers;

import in.project.entity.CustomerEntity;
import in.project.repository.CustomerRepository;
import in.project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private final CustomerRepository customerRepository;

	CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

    // Create a new customer
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CustomerEntity customer){
    	System.out.println("Dekho bhai kya hai to "+customer);
        try {
            CustomerEntity savedCustomer = customerService.saveCustomer(customer);
            return ResponseEntity.ok(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Return error message if email exists
        }
    	
    	
    	
    	
//		CustomerEntity cs=new CustomerEntity();
//		cs.setCnfpassword(customer.getCnfpassword());
//		cs.setEmail(customer.getEmail());
//		cs.setMobile(customer.getMobile());
//		cs.setName(customer.getName());
//		cs.setPassword(customer.getPassword());
//		
//		customerRepository.save(cs);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Customer Registered Successfully");
    }
    

    // Get all customers
    @GetMapping("/data")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customers = customerService.getAllCustomer();
        
        return ResponseEntity.ok(customers);
    }

    // Get customer by ID
    @GetMapping("/profile/{customerId}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long customerId) {
        Optional<CustomerEntity> customer = customerService.getcustomerById(customerId);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update customer
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> updateCustomer(
            @PathVariable Long customerId, 
            @RequestBody CustomerEntity customer) {
        CustomerEntity updatedCustomer = customerService.updatecustomer(customerId, customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete customer
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    //login customer
    @PostMapping("/login/1")
    public ResponseEntity<?> customerlogin(@RequestBody CustomerEntity customer) {
        try {
        	
            CustomerEntity loggedInCustomer = customerService.loginCustomer(customer.getEmail(), customer.getPassword());
            return ResponseEntity.ok(loggedInCustomer); // Returns customer details if login is successful
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Returns error message
        }
    }
    

//    @PutMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
//        return customerService.forgotPassword(request.getEmail(), request.getNewPassword());
//    }   for that need entity class
    
}
