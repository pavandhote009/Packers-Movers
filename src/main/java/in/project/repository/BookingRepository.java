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
	
	



}