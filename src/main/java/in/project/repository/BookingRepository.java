package in.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.project.entity.BookingEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

}