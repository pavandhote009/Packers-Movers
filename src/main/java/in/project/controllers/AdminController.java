package in.project.controllers;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.project.entity.AdminEntity;
import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
import in.project.services.AdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")

public class AdminController {
    @Autowired
    private AdminService adminService;

    
    // Admin Registration API
//    @PostMapping("/register")
//    public ResponseEntity<AdminEntity> registerAdmin(@RequestBody AdminEntity admin) {
//        AdminEntity savedAdmin = adminService.registerAdmin(admin);
//        return ResponseEntity.ok(savedAdmin);
//    }
//    
    @PostMapping("/login/3")
    public ResponseEntity<?> login(@RequestBody AdminEntity adminEntity) {
        try {
            AdminEntity admin = adminService.login(adminEntity.getEmail(), adminEntity.getPassword());
            return ResponseEntity.ok(admin);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }	
    
    @GetMapping("/getadmin/{adminId}")
	public ResponseEntity<AdminEntity> getAdminData(@PathVariable Long adminId) {
		return ResponseEntity.ok(adminService.getAdminData(adminId));
	}

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        return ResponseEntity.ok(adminService.getAllCustomers());
    }

    @GetMapping("/agents")
    public ResponseEntity<List<AgentEntity>> getAllAgents() {
        return ResponseEntity.ok(adminService.getAllAgents());
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        adminService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @DeleteMapping("/agents/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id) {
        adminService.deleteAgent(id);
        return ResponseEntity.ok("Agent deleted successfully");
    }
    
    
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingEntity>> getAllBookings() {
        return ResponseEntity.ok(adminService.getAllBookings());
    }
//
//    @GetMapping("/quotations")
//    public ResponseEntity<List<QuotationEntity>> getAllQuotations() {
//        return ResponseEntity.ok(adminService.getAllQuotations());
//    }
    
}