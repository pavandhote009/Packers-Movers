package in.project.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
import in.project.entity.BookingEntity.BookingStatus;
import in.project.repository.BookingRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingEntity saveBooking(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<BookingEntity> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public BookingEntity updatebooking(Long bookingId, BookingEntity booking) {
        Optional<BookingEntity> existingBooking = bookingRepository.findById(bookingId);
        if (existingBooking.isPresent()) {
            BookingEntity uB = existingBooking.get();
            uB.setCustomer(booking.getCustomer());
            uB.setProvider(booking.getProvider());
            uB.setBookingDate(booking.getBookingDate());
            uB.setPickupAddress(booking.getPickupAddress());
            uB.setDropAddress(booking.getDropAddress());
            uB.setTotalPrice(booking.getTotalPrice());
            uB.setBookingStatus(booking.getBookingStatus());
            uB.setPaymentStatus(booking.getPaymentStatus());
   
            return bookingRepository.save(uB);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}

//private Long bookingId;
//private CustomerEntity customer;
//private AgentEntity provider;
//private LocalDate bookingDate; // No @Temporal needed for Java 8+ types
//private String pickupAddress;
//private String dropAddress;
//private Double totalPrice; // Wrapper class is used to handle null values
//private BookingStatus bookingStatus; // Enum type
//private String paymentStatus;
//private LocalDateTime createDate;
//private LocalDateTime updateDate;
