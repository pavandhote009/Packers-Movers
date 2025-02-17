package in.Packers.Movers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Packers.Movers.Entity.customerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<customerEntity, Long> {

}