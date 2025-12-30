package sirma.SantaWorkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sirma.SantaWorkshop.entity.dto.GiftDto;

@Controller
public class CreateController {

    @GetMapping("/createPage")
    public String showCreatePage(Model model) {
        model.addAttribute("newGift", new GiftDto());
        return "createPage";
    };


}
