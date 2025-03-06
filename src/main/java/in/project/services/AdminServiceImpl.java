package in.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.AdminEntity;
import in.project.entity.BookingEntity;
import in.project.repository.AdminRepository;
import in.project.repository.BookingRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	
	    @Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private BookingRepository bookingRepository;

	    // Fetch all users
	    public List<AdminEntity> getAllUsers() {
	        return adminRepository.findAll();
	    }

	    // Approve a booking
	    public void approveBooking(Long bookingId) {
	        BookingEntity booking = bookingRepository.findById(bookingId)
	            .orElseThrow(() -> new RuntimeException("Booking not found"));
	        booking.setStatus("APPROVED");
	        bookingRepository.save(booking);
	    }

	    // Reject a booking
	    public void rejectBooking(Long bookingId) {
	    	BookingEntity booking = bookingRepository.findById(bookingId)
	            .orElseThrow(() -> new RuntimeException("Booking not found"));
	        booking.setStatus("REJECTED");
	        bookingRepository.save(booking);
	    }

	    // Delete a user
	    public void deleteUser(Long userId) {
	        adminRepository.deleteById(userId);
	    }

	    // Fetch all bookings
	    public List<BookingEntity> getAllBookings() {
	        return bookingRepository.findAll();
	    }
	

}
