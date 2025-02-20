package in.project.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.CustomerEntity;
import in.project.repository.CustomerRepository;
import jakarta.persistence.Column;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
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
            updatedCustomer.setFirstName(customer.getFirstName());
            updatedCustomer.setLastName(customer.getLastName());
            updatedCustomer.setDateOfBirth(customer.getDateOfBirth());
            updatedCustomer.setMobile(customer.getMobile());
            updatedCustomer.setNationality(customer.getNationality());
            updatedCustomer.setFullAddress(customer.getFullAddress());
            updatedCustomer.setCity(customer.getCity());
            updatedCustomer.setState(customer.getState());
            updatedCustomer.setCountry(customer.getCountry());

            return customerRepository.save(updatedCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
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
