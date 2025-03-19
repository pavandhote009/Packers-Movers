package in.project.dto;

import lombok.Data;

@Data
public class QuotationRequestDTO {
    private Long customerId;
    private Long agentId;
    private String serviceType;
    private Double distanceInKm;
    private Double pricePerKm;
    private Double totalPrice;
    private Double taxAmount;
    private Double finalAmount;
    private String pickupAddress;
    private String dropAddress;
}
