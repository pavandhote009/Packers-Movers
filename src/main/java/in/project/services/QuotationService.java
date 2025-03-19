package in.project.services;

import java.util.List;
import java.util.Optional;

import in.project.entity.AgentEntity;
import in.project.entity.QuotationEntity;

public interface QuotationService {
	public List<QuotationEntity> getAllQuotations();

	public List<QuotationEntity> getQuotationsByAgentId(Long agentId) ;
	public List<QuotationEntity> getQuotationByCustomerId(Long customerId) ;

	public QuotationEntity saveQuotation(QuotationEntity quotation);

	public void deleteQuotation(Long quotationId);

	public QuotationEntity updateQuotation(Long quotationId, QuotationEntity updatedQuotation);

}