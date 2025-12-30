package sirma.SantaWorkshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sirma.SantaWorkshop.entity.Delivery;
import sirma.SantaWorkshop.repository.DeliveryRepository;

public class DeliveryController {
    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping("/track/{code}")
    public Delivery track(@PathVariable String code) {
        return deliveryRepository.findByTrackingCode(code)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }
}
