package in.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.project.entity.BookingEntity;
import in.project.services.BookingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {
	
		private final BookingService bookingService;
		@Autowired
		public BookingController(BookingService bookingService) {
			this.bookingService=bookingService;
		}

	    @PostMapping("/booking")
	    public ResponseEntity<?> createBooking(@RequestBody BookingEntity booking) {
	    	System.out.println("Dekho bhai kya hai to "+booking);
	          BookingEntity newBooking = bookingService.saveBooking(booking);
                return ResponseEntity.status(HttpStatus.CREATED).body("Booking Created Successfully ! You will be Notified with confirmation later ! ");
	    }
	    
	    @GetMapping("/{customerId}/quotation")
		public ResponseEntity<?> getQuotation(@PathVariable Long customerId) {
			List<BookingEntity> bookings = bookingService.getAllBookings();
			return ResponseEntity.ok(bookings);
		}
	    
	    

	    @GetMapping("/allbooking")
	    public ResponseEntity<List<BookingEntity>> getAllBookings() {
	        List<BookingEntity> bookings = bookingService.getAllBookings();
	        return ResponseEntity.ok(bookings);
	    }

	    @GetMapping("/{bookingId}")
	    public ResponseEntity<BookingEntity> getBookingById(@PathVariable Long bookingId) {
	        Optional<BookingEntity> booking = bookingService.getBookingById(bookingId);
	        return booking.map(ResponseEntity::ok)
	                      .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PutMapping("/update/{bookingId}")
	    public ResponseEntity<BookingEntity> updateBooking(@PathVariable Long bookingId, @RequestBody BookingEntity booking) {
	        BookingEntity updatedBooking = bookingService.updatebooking(bookingId, booking);
	        return updatedBooking != null ? ResponseEntity.ok(updatedBooking) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/delete/{bookingId}")
	    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
	        bookingService.deleteBooking(bookingId);
	        return ResponseEntity.noContent().build();
	    }
	}

