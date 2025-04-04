package in.project.services;

import in.project.entity.AgentEntity;
import in.project.entity.QuotationEntity;
import in.project.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuotationServiceImpl implements QuotationService {

	@Autowired
	private QuotationRepository quotationRepository;

	@Override
	public List<QuotationEntity> getAllQuotations() {
		return quotationRepository.findAll();
	}

	@Override
	public List<QuotationEntity> getQuotationsByAgentId(Long agentId) {
	    return quotationRepository.findByAgent_AgentId(agentId);
	}


	@Override
	public QuotationEntity saveQuotation(QuotationEntity quotation) {
		return quotationRepository.save(quotation);
	}

	@Override
	public void deleteQuotation(Long quotationId) {
		quotationRepository.deleteById(quotationId);
	}

	@Override
	public QuotationEntity updateQuotation(Long quotationId, QuotationEntity updatedQuotation) {
		Optional<QuotationEntity> existingQuotation = quotationRepository.findById(quotationId);

		if (existingQuotation.isPresent()) {
			QuotationEntity quotation = existingQuotation.get();

			// Updating Customer & Agent References
			quotation.setCustomer(updatedQuotation.getCustomer());
			quotation.setAgent(updatedQuotation.getAgent());

			// Updating Payment Reference
//			quotation.setPayment(updatedQuotation.getPayment());

			// Updating Service Details
			quotation.setService(updatedQuotation.getService());
			quotation.setDistanceInKm(updatedQuotation.getDistanceInKm());
			quotation.setPricePerKm(updatedQuotation.getPricePerKm());
			quotation.setTotalPrice(updatedQuotation.getTotalPrice());
			quotation.setTaxAmount(updatedQuotation.getTaxAmount());
			quotation.setFinalAmount(updatedQuotation.getFinalAmount());

			// Updating Pickup & Drop Details
			quotation.setPickupAddress(updatedQuotation.getPickupAddress());
			quotation.setDropAddress(updatedQuotation.getDropAddress());

			// Updating Transaction & Status
//			quotation.setTransactionId(updatedQuotation.getTransactionId());
//			quotation.setStatus(updatedQuotation.getStatus());

			return quotationRepository.save(quotation); // Save updated quotation
		} else {
			throw new RuntimeException("Quotation not found with id: " + quotationId);
		}
	}

	@Override
	public List<QuotationEntity> getQuotationByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return quotationRepository.findByCustomer_CustomerId(customerId);
	}

}