package in.project.controllers;

import in.project.dto.QuotationRequestDTO;
import in.project.dto.QuotationRequestDTO;
import in.project.entity.AgentEntity;
import in.project.entity.CustomerEntity;
import in.project.entity.QuotationEntity;
import in.project.services.AgentService;
import in.project.services.CustomerService;
import in.project.services.QuotationService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;
    
    @Autowired
    private CustomerService customerService;
  
    @Autowired
    private AgentService agentService;
  

    // Get all quotations
    @GetMapping("/quotations/all")
    public ResponseEntity<List<QuotationEntity>> getAllQuotations() {
        return ResponseEntity.ok(quotationService.getAllQuotations());
    }

    // Get quotation by ID
    @GetMapping("/agentquote/{agentId}")
    public ResponseEntity<List<QuotationEntity>> getQuotationsByAgentId(@PathVariable Long agentId) {
        List<QuotationEntity> quotations = quotationService.getQuotationsByAgentId(agentId);
        return quotations.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(quotations);
    }

    // Get quotation by ID
    @GetMapping("/customerquote/{customerId}")
    public ResponseEntity<List<QuotationEntity>> getQuotationByCustomerId(@PathVariable Long customerId) {
        List<QuotationEntity> quotations = quotationService.getQuotationByCustomerId(customerId);
        return quotations.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(quotations);
    }


    // Create a new quotation
    @PostMapping(value = "/quotations")
	public ResponseEntity<QuotationEntity> createQuotation(@RequestBody QuotationEntity quotation) {
    	
		QuotationEntity savedQuotation = quotationService.saveQuotation(quotation);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedQuotation);
    	

//        if (customerId == null || agentId == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer ID and Agent ID are required");
//        }	
//
//        Optional<CustomerEntity> customerOptional = customerService.getcustomerById(customerId);
//        Optional<AgentEntity> agentOptional = agentService.getAgentById(agentId);
//
//        if (customerOptional.isEmpty() || agentOptional.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer or Agent not found");
//        }
//
//        // Create new QuotationEntity
//        QuotationEntity quotation = new QuotationEntity();
//        quotation.setCustomer(customerOptional.get());
//        quotation.setAgent(agentOptional.get());
//        quotation.setServiceType(requestDTO.getServiceType());
//        quotation.setDistanceInKm(requestDTO.getDistanceInKm());
//        quotation.setPricePerKm(requestDTO.getPricePerKm());
//        quotation.setTotalPrice(requestDTO.getTotalPrice());
//        quotation.setTaxAmount(requestDTO.getTaxAmount());
//        quotation.setFinalAmount(requestDTO.getFinalAmount());
//        quotation.setPickupAddress(requestDTO.getPickupAddress());
//        quotation.setDropAddress(requestDTO.getDropAddress());
//
//        QuotationEntity savedQuotation = quotationService.saveQuotation(quotation);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuotation);
    }



    // *Update quotation*
    @PutMapping("/{quotationId}")
    public ResponseEntity<QuotationEntity> updateQuotation(@PathVariable Long id, @RequestBody QuotationEntity updatedQuotation) {
        try {
            QuotationEntity quotation = quotationService.updateQuotation(id, updatedQuotation);
            return ResponseEntity.ok(quotation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete quotation
    @DeleteMapping("/quotations/{quotationId}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable Long quotationId) {
        quotationService.deleteQuotation(quotationId);
        return ResponseEntity.noContent().build();
    }
}