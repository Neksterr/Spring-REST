package sirma.SantaWorkshop.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryDto {
    private Long id;

    @NotNull
    @Size(min = 5, max = 120)
    private String address;
    @NotNull
    private String recipientName;
    @NotNull
    @Size(min = 1)
    private List<Long> giftIds;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime estimatedArrival;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public List<Long> getGiftIds() {
        return giftIds;
    }

    public void setGiftIds(List<Long> giftIds) {
        this.giftIds = giftIds;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(LocalDateTime estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
}
