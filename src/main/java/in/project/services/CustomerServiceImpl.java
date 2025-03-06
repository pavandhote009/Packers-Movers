package in.project.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.project.entity.CustomerEntity;
import in.project.repository.CustomerRepository;
import jakarta.persistence.Column;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    @Override
//    public CustomerEntity saveCustomer(CustomerEntity customer) {
//        return customerRepository.save(customer);
//    }
//    
    
    
    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) throws Exception {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists. Please use another email.");
        }
        return customerRepository.save(customer);
    }

    
    
    

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<CustomerEntity> getcustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public CustomerEntity updatecustomer(Long customerId, CustomerEntity customer) {
        Optional<CustomerEntity> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            CustomerEntity updatedCustomer = existingCustomer.get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setPassword(customer.getPassword());

            return customerRepository.save(updatedCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
    
    // Login method
    public CustomerEntity loginCustomer(String email, String password) throws Exception {
        Optional<CustomerEntity> customerOptional = customerRepository.findByEmail(email);

        if (customerOptional.isPresent()) {
            CustomerEntity customer = customerOptional.get();
            if (customer.getPassword().equals(password)) {
                return customer; // Successful login
            } else {
                throw new BadRequestException("Invalid email or password!");
            }
        } else {
            throw new BadRequestException("Customer not found with email: " + email);
        }
    }
    //forgot password
    public ResponseEntity<String> forgotPassword(String email, String newPassword) {
        Optional<CustomerEntity> customerOpt = customerRepository.findByEmail(email);

        if (customerOpt.isPresent()) {
            CustomerEntity customer = customerOpt.get();
            customer.setPassword(newPassword);  // You should hash the password before saving
            customerRepository.save(customer);
            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found. Please register first.");
        }
    }
    
    
}
//private Long customerId;  
//private String name;
//private String email;
//private String phone;
//private String address;
//private String password;
//private String firstName;
//private String lastName;
//private LocalDate dateOfBirth;  // Correct for DATE type
//private String mobile;
//private String nationality;
//private String fullAddress;
//private String city;
//private String state;
//private String country;
