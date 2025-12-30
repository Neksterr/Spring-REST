package sirma.SantaWorkshop.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sirma.SantaWorkshop.entity.Delivery;
import sirma.SantaWorkshop.entity.dto.DeliveryDto;
import sirma.SantaWorkshop.entity.dto.DeliveryStatusUpdateDto;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;
import sirma.SantaWorkshop.repository.DeliveryRepository;
import sirma.SantaWorkshop.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryRepository deliveryRepository, DeliveryService deliveryService) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryService = deliveryService;
    }

    @GetMapping("/track/{code}")
    public Delivery track(@PathVariable String code) {
        return deliveryRepository.findByTrackingCode(code)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDto createDelivery(
            @Valid @RequestBody DeliveryDto dto) {

        return deliveryService.createDelivery(dto);
    }

    @GetMapping
    public List<DeliveryDto> getAllDeliveries(
            @RequestParam(required = false) DeliveryStatus status,
            @RequestParam(required = false) String recipientName) {

        return deliveryService.getAllDeliveries(status, recipientName);
    }
    @PatchMapping("/{id}/status")
    public DeliveryDto updateDeliveryStatus(
            @PathVariable Long id,
            @RequestBody DeliveryStatusUpdateDto dto) {

        return deliveryService.updateDeliveryStatus(id, dto.getDeliveryStatus());
    }
}
