package in.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.project.entity.AgentEntity;

@Repository
public interface AgentRepository extends JpaRepository<AgentEntity, Long>{

	 public Optional<AgentEntity> findByEmail(String email);	
}