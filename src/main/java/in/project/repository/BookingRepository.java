package in.project.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	List<BookingEntity> findByCustomer(CustomerEntity customer);
    
    @Query("SELECT b FROM BookingEntity b JOIN FETCH b.customer") // Ensures customer data is loaded
    List<BookingEntity> findAllWithCustomers();
	
	
	@Query(value = """
		    SELECT 
		        c.name AS customerName, 
		        c.email AS customerEmail, 
		        c.mobile AS customerMobile,
		        a.agentName AS agentName,
		        a.id AS agentId,
		        b.serviceName AS serviceName,
		        b.pickupAddress AS pickupAddress,
		        b.dropAddress AS dropAddress,
		        b.date AS bookingDate,
		        b.reference AS bookingReference,
		        p.advance AS advancePayment,
		        p.remaining AS remainingPayment
		    FROM customer c
		    JOIN booking b ON c.id = b.customer_id
		    JOIN agents a ON b.agent_id = a.id
		    JOIN payment p ON b.id = p.booking_id
		    WHERE c.id = :customerId
		""", nativeQuery = true)
		List<Map<String, Object>> getQuotation(@Param("customerId") Long customerId);


}