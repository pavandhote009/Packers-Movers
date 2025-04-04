package in.project.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
import in.project.repository.BookingRepository;
import in.project.repository.CustomerRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public  class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    

    
    @Autowired
    private CustomerRepository CustomerRepository;
  
//    @Override
//    public List<Map<String, Object>> quotationDetails(Long customerId) {
//    	return bookingRepository.getQuotation(customerId);
//    }
 

    @Override
    public BookingEntity saveBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> getAllBookings() {
    	
        return bookingRepository.findAllWithCustomers(); // Uses custom query to fetch customers

    }
    public List<BookingEntity> getBookingsByCustomerId(Long customerId) {
        CustomerEntity customer = CustomerRepository.findById(customerId)
                                       .orElseThrow(() -> new RuntimeException("Customer not found"));
        return bookingRepository.findByCustomer(customer);
    }





    @Override
    public BookingEntity updatebooking(Long bookingId, BookingEntity booking) {
        Optional<BookingEntity> existingBooking = bookingRepository.findById(bookingId);
        if (existingBooking.isPresent()) {
            BookingEntity uB = existingBooking.get();
            uB.setBookingDate(booking.getBookingDate());
            uB.setPickupAddress(booking.getPickupAddress());
            uB.setDropAddress(booking.getDropAddress());
            uB.setDetails(booking.getDetails());
            uB.setReferance(booking.getReferance());
            uB.setCreatedAt(booking.getCreatedAt());
            uB.setUpdatedAt(booking.getUpdatedAt());
            
   
            return bookingRepository.save(uB);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

	@Override
	public List<Map<String, Object>> quotationDetails(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}


