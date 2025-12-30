package sirma.SantaWorkshop.entity.dto;

import jakarta.validation.constraints.NotNull;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;

public class DeliveryStatusUpdateDto {
    @NotNull
    private DeliveryStatus deliveryStatus;

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
