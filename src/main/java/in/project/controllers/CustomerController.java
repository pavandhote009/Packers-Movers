
package in.project.controllers;

import in.project.dto.ResetPasswordRequest;
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
@RequestMapping("/api")
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
    @DeleteMapping("/deletecustomer/{customerId}")
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
    
//    forgot password
    @PutMapping("/forgotpassword")
    public ResponseEntity<String> forgotPassword(@RequestBody CustomerEntity request) {
        return customerService.sendOtp(request.getEmail());
    } 
    
    // Verify OTP and reset password
    @PutMapping("/verifyotp")
    public ResponseEntity<String> verifyOtp(@RequestBody ResetPasswordRequest request) {
        Optional<CustomerEntity> customerOpt = customerRepository.findByEmail(request.getEmail());
        System.out.println("Customer otp is "+customerOpt.get().getOtp());

        if (customerOpt.isPresent()) {
            CustomerEntity customer = customerOpt.get();

            if (customer.getOtp() != null && customer.getOtp().equals(request.getOtp())) {
                return ResponseEntity.ok("OTP verified successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        }
    }
    
    @PutMapping("/resetpassword")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        Optional<CustomerEntity> customerOpt = customerRepository.findByEmail(request.getEmail());

        if (customerOpt.isPresent()) {
            CustomerEntity customer = customerOpt.get();

            customer.setPassword(request.getNewPassword()); // Storing without hashing (as per your choice)
            customerRepository.save(customer);

            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        }
    }



    
}
