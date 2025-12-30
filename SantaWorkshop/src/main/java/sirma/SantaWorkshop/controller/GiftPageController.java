package sirma.SantaWorkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sirma.SantaWorkshop.service.GiftService;

@Controller
public class GiftPageController {
    private final GiftService giftService;

    public GiftPageController(GiftService giftService) {
        this.giftService = giftService;
    }
    @GetMapping("/gifts")
    public String showGiftsPage(Model model) {
        model.addAttribute("giftList", giftService.getAllGifts());
        return "giftList";
    }
}
