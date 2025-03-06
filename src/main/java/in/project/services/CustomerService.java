package in.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import in.project.entity.CustomerEntity;

public interface CustomerService {
		 public CustomerEntity saveCustomer(CustomerEntity customer) throws Exception;
		   public List<CustomerEntity> getAllCustomer();
		   public Optional<CustomerEntity> getcustomerById(Long customerId);
		   public CustomerEntity updatecustomer(Long customerId, CustomerEntity customer);
		   public void deleteCustomer(Long customerId);
		   public CustomerEntity loginCustomer(String email, String password) throws Exception;
		   ResponseEntity<String> forgotPassword(String email, String newPassword);

}
