package in.project.controllers;

import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
import in.project.services.BookingService;
import in.project.services.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {
	
		private final BookingService bookingService;
		@Autowired
		private CustomerService customerService;
		@Autowired
		public BookingController(BookingService bookingService) {
			this.bookingService=bookingService;
		}
		@PostMapping("/booking")
		public ResponseEntity<?> createBooking(
		    @Valid @RequestBody BookingEntity bookingRequest,
		    @RequestParam Long customerId) { // Accept customerId from query parameter

		    try {
		        Optional<CustomerEntity> customerOptional = customerService.getcustomerById(customerId);
		        
		        if (customerOptional.isEmpty()) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                .body(Map.of("status", "error", "message", "Customer not found with ID: " + customerId));
		        }

		        bookingRequest.setCustomer(customerOptional.get());

		        BookingEntity savedBooking = bookingService.saveBooking(bookingRequest);
		        
		        return ResponseEntity.status(HttpStatus.CREATED)
		            .body(Map.of("status", "success", "message", "Booking created successfully", "data", savedBooking));
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(Map.of("status", "error", "message", "Error creating booking: " + e.getMessage()));
		    }
		}



	    @GetMapping("/allbooking")
	    public ResponseEntity<List<BookingEntity>> getAllBookings() {
	        List<BookingEntity> bookings = bookingService.getAllBookings();
	        return ResponseEntity.ok(bookings);
	    }
	    @GetMapping("/booking/{customerId}")
	    public ResponseEntity<List<BookingEntity>> getBookingsByCustomer(@PathVariable Long customerId) {
	        List<BookingEntity> bookings = bookingService.getBookingsByCustomerId(customerId);
	        
	        if (bookings.isEmpty()) {
	            return ResponseEntity.notFound().build(); // No bookings found
	        }
	        
	        return ResponseEntity.ok(bookings); // Return all bookings
	    }


	    @PutMapping("/update/{bookingId}")
	    public ResponseEntity<BookingEntity> updateBooking(@PathVariable Long bookingId, @RequestBody BookingEntity booking) {
	        BookingEntity updatedBooking = bookingService.updatebooking(bookingId, booking);
	        return updatedBooking != null ? ResponseEntity.ok(updatedBooking) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/deletebooking/{bookingId}")
	    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
	        bookingService.deleteBooking(bookingId);
	        return ResponseEntity.noContent().build();
	    }
	}

