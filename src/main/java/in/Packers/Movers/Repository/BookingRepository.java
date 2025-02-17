package in.Packers.Movers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Packers.Movers.Entity.BookingEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

}