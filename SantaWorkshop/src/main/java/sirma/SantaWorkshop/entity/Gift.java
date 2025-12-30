package sirma.SantaWorkshop.entity;

import jakarta.persistence.*;
import sirma.SantaWorkshop.entity.enums.Category;
import sirma.SantaWorkshop.entity.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "gifts")
public class Gift extends BaseEntity {
    @Column(name = "gift_name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
    @Column(name = "target_age", nullable = false)
    private int targetAge;
    @Column(name = "is_wrapped")
    private boolean isWrapped;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Column(name = "created_At")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Gift() {

    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }



    public Gift(Delivery delivery) {
        this.delivery = delivery;
    }

    public Gift(String name, Category category, int targetAge, boolean isWrapped, Status status, LocalDateTime createdAt) {
        this.name = name;
        this.category = category;
        this.targetAge = targetAge;
        this.isWrapped = isWrapped;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(int targetAge) {
        this.targetAge = targetAge;
    }

    public boolean isWrapped() {
        return isWrapped;
    }

    public void setWrapped(boolean wrapped) {
        isWrapped = wrapped;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
