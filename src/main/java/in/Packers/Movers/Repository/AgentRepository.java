package in.Packers.Movers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Packers.Movers.Entity.AgentEntity;

@Repository
public interface AgentRepository extends JpaRepository<AgentEntity, Long>{

}