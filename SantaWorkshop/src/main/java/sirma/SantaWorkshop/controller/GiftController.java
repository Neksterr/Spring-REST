package sirma.SantaWorkshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sirma.SantaWorkshop.entity.Gift;
import sirma.SantaWorkshop.entity.dto.GiftDto;
import sirma.SantaWorkshop.repository.GiftRepository;
import sirma.SantaWorkshop.service.GiftService;
import java.util.List;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {
    private final GiftService giftService;
    private final GiftRepository giftRepository;

    public GiftController(GiftService giftService, GiftRepository giftRepository) {
        this.giftService = giftService;
        this.giftRepository = giftRepository;
    }
    @GetMapping
    public List<GiftDto> getAllGifts() {
        return giftService.getAllGifts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GiftDto createGift(@RequestBody GiftDto dto) {
        return giftService.createGift(dto);
    }

    @GetMapping("/{id}")
    public GiftDto showGift(@PathVariable Long id){
        return giftService.getGiftById(id);
    }

    @PutMapping("/{id}")
    public GiftDto updateGift(@PathVariable Long id,@RequestBody GiftDto giftDto){
        return  giftService.updateGift(id,giftDto);
    }

    @PatchMapping("/{id}/wrap")
    public GiftDto wrapGift(@PathVariable Long id){
        return  giftService.getWrapped(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletGift(@PathVariable Long id){
        giftService.deleteGiftById(id);
    }
}
