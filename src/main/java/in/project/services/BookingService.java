package in.project.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.project.entity.BookingEntity;

@Service
public interface BookingService {
	 public BookingEntity saveBooking(BookingEntity Booking);
	   public List<BookingEntity> getAllBookings();
	   public Optional<BookingEntity> getBookingById(Long bookingId);
	   public BookingEntity updatebooking(Long bookingId, BookingEntity Booking);
	   public void deleteBooking(Long bookingId);
	    public List<Map<String, Object>> quotationDetails(Long customerId) ;
}
