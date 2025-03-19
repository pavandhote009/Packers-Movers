package in.project.services;

import java.util.List;
import in.project.entity.AdminEntity;
import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;

public interface AdminService {
	 AdminEntity registerAdmin(AdminEntity admin);
    AdminEntity login(String email, String password) throws Exception;
    List<CustomerEntity> getAllCustomers();
    List<AgentEntity> getAllAgents();
    public AdminEntity getAdminData(Long adminId);
    void deleteCustomer(Long customerId);
    void deleteAgent(Long agentId);
	List<BookingEntity> getAllBookings();
}