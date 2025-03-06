package in.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.project.entity.AdminEntity;
import jakarta.persistence.Id;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
	    Optional<AdminEntity> findByEmail(String email);
	

}
