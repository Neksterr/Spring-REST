package sirma.SantaWorkshop.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sirma.SantaWorkshop.entity.dto.GiftDto;
import sirma.SantaWorkshop.entity.enums.Category;
import sirma.SantaWorkshop.entity.enums.SkillLevel;
import sirma.SantaWorkshop.entity.enums.Status;
import sirma.SantaWorkshop.service.DeliveryService;
import sirma.SantaWorkshop.service.ElvesService;
import sirma.SantaWorkshop.service.GiftService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RestController("/createPage")
public class CreatePageController {

    private final GiftService giftService;
    private final ElvesService elvesService;
    private final DeliveryService deliveryService;

    public CreatePageController(GiftService giftService,
                                ElvesService elvesService,
                                DeliveryService deliveryService) {
        this.giftService = giftService;
        this.elvesService = elvesService;
        this.deliveryService = deliveryService;
    }
    @GetMapping()
    public String showCreatePage(Model model) {
        model.addAttribute("gifts", giftService.getAllGifts());
        model.addAttribute("elves", elvesService.getAllElves());
        return "createPage";
    }
    @PostMapping("/gift")
    public String createGift(
            @RequestParam String giftName,
            @RequestParam Category category,
            @RequestParam(required = false) Integer targetAge

    ) {
        GiftDto dto = new GiftDto();
        dto.setName(giftName);
        dto.setCategory(category);
        dto.setTargetAge(targetAge);
        giftService.createGift(dto);

        return "redirect:/gifts";
    }

    @PostMapping("/elf")
    public String createElf(
            @RequestParam String elfName,
            @RequestParam SkillLevel elfLevel
    ) {
        elvesService.createElf(elfName, elfLevel);
        return "redirect:/elves";
    }

    @GetMapping("/createDelivery")
    public String showCreateDeliveryForm(Model model) {
        model.addAttribute("gifts", giftService.getAllGifts());
        model.addAttribute("elves", elvesService.getAllElves());
        return "createDelivery";
    }
    @PostMapping("/delivery")
    public String createDelivery(
            @RequestParam String recipientName,
            @RequestParam String address,
            @RequestParam Long giftId,
            @RequestParam Long elfId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate deliveryDate
    ) {
        deliveryService.createDelivery(
                recipientName,
                address,
                giftId,
                elfId,
                deliveryDate
        );

        return "redirect:/deliveries";
    }
}
