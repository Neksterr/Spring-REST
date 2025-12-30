package sirma.SantaWorkshop.entity;

import jakarta.persistence.*;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "deliveries", uniqueConstraints = {
        @UniqueConstraint(columnNames = "trackingCode")
})
public class Delivery extends BaseEntity{
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "recipient_name", nullable = false)
    private String recipientName;
    @ManyToMany
    @JoinTable(name = "delivery_gifts",
            joinColumns = @JoinColumn(name = "delivery_id"))
    private List<Gift> gifts;
    @ManyToOne
    private Elf elf;
    @Column(nullable = false, unique = true)
    private String trackingCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;
    @Column(name = "estimated_arrival")
    private LocalDate estimatedArrival;

    public Delivery(String address, String recipientName, List<Gift> gifts, Elf elf, String trackingCode, DeliveryStatus deliveryStatus, LocalDate estimatedArrival) {
        this.address = address;
        this.recipientName = recipientName;
        this.gifts = gifts;
        this.elf = elf;
        this.trackingCode = trackingCode;
        this.deliveryStatus = deliveryStatus;
        this.estimatedArrival = estimatedArrival;
    }

    public Delivery() {

    }
    @PrePersist
    public void generateTrackingCode() {
        this.trackingCode = "SANTA-" + UUID.randomUUID().toString().substring(0, 7).toUpperCase();
    }

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

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public Elf getElf() {
        return elf;
    }

    public void setElf(Elf elf) {
        this.elf = elf;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(LocalDate estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
}
