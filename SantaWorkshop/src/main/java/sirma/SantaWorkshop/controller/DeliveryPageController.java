package sirma.SantaWorkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sirma.SantaWorkshop.entity.Delivery;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;
import sirma.SantaWorkshop.service.DeliveryService;

import java.util.List;

@Controller
public class DeliveryPageController {
    private final DeliveryService deliveryService;

    public DeliveryPageController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveries")
    public String showDeliveries(
            @RequestParam(required = false) DeliveryStatus status,
            Model model) {

        List<Delivery> deliveries =
                (status != null)
                        ? deliveryService.getDeliveriesByStatus(status)
                        : deliveryService.getAllDeliveries();

        model.addAttribute("deliveryList", deliveries);
        model.addAttribute("statuses", DeliveryStatus.values());
        model.addAttribute("selectedStatus", status);

        return "deliveryList";
    }
}
