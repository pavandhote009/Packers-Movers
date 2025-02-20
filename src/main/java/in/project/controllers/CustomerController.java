
package in.project.controllers;

import in.project.entity.CustomerEntity;
import in.project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create a new customer
    @PostMapping("/data")
    public ResponseEntity<CustomerEntity> saveCustomer(@RequestBody CustomerEntity customer) {
    	
    	System.out.println(customer.getFirstName());
    	
        CustomerEntity savedCustomer = customerService.saveCustomer(customer);
        
        return ResponseEntity.ok(savedCustomer);
    }

    // Get all customers
    @GetMapping("/")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    // Get customer by ID
    @GetMapping("/{customerId}")
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
}
