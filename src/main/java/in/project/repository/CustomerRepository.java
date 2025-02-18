package in.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.project.entity.customerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<customerEntity, Long> {

}