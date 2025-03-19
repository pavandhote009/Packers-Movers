package in.project.services;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.AdminEntity;
import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
import in.project.repository.AdminRepository;
import in.project.repository.AgentRepository;
import in.project.repository.BookingRepository;
import in.project.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    AdminEntity adminEntity =new AdminEntity(); 
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AgentRepository agentRepository;

    private BookingRepository bookingRepository;
    
    @Override
    public AdminEntity registerAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }
    
    @Override
    public AdminEntity login(String email, String password) throws BadRequestException {
        Optional<AdminEntity> adminOptional = adminRepository.findByEmail(email);

        if (adminOptional.isEmpty()) {
            throw new BadRequestException("Admin not found");
        }

        AdminEntity admin = adminOptional.get();

        if (!admin.getPassword().equals(password)) {
            throw new BadRequestException("Invalid email or password!");
        }

        return admin;
    }
//	admin.getPassword().equals(password)
    

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<AgentEntity> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void deleteAgent(Long agentId) {
        agentRepository.deleteById(agentId);
    }
    

    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
        
    }

	@Override
	public AdminEntity getAdminData(Long adminId) {
		
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId).get();
	}

//    public List<QuotationEntity> getAllQuotations() {
//        return quotationRepository.findAll();
//    }
}