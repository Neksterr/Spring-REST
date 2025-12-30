package sirma.SantaWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sirma.SantaWorkshop.entity.Delivery;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

    Optional<Delivery> findByTrackingCode(String trackingCode);
    List<Delivery> findAllByDeliveryStatus(DeliveryStatus status);

}
