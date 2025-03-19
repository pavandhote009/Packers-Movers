package in.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.project.entity.AgentEntity;
import in.project.entity.QuotationEntity;

public interface QuotationRepository extends JpaRepository<QuotationEntity, Long> {

    List<QuotationEntity> findByAgent_AgentId(Long agentId);

	List<QuotationEntity> findByCustomer_CustomerId(Long customerId);

}
