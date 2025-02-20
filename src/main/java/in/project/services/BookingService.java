package in.project.services;

import java.util.List;
import java.util.Optional;

import in.project.entity.BookingEntity;

public interface BookingService {
	 public BookingEntity saveBooking(BookingEntity Booking);
	   public List<BookingEntity> getAllBookings();
	   public Optional<BookingEntity> getBookingById(Long bookingId);
	   public BookingEntity updatebooking(Long bookingId, BookingEntity Booking);
	   public void deleteBooking(Long bookingId);
}
