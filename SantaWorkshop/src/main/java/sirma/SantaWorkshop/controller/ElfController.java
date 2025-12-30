package sirma.SantaWorkshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sirma.SantaWorkshop.entity.dto.ElfDto;
import sirma.SantaWorkshop.service.ElvesService;

import java.util.List;

@RestController
@RequestMapping("/api/elves")
public class ElfController {
    private final ElvesService elvesService;

    public ElfController(ElvesService elvesService) {
        this.elvesService = elvesService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ElfDto createElf(@RequestBody ElfDto dto) {
        return elvesService.createElf(dto);
    }

    @GetMapping
    public List<ElfDto> getAllElves() {
        return elvesService.getAllElves();
    }


    @GetMapping("/{id}")
    public ElfDto getElfById(@PathVariable Long id) {
        return elvesService.getElfById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteElf(@PathVariable Long id) {
        elvesService.deleteElfById(id);
    }

    @PostMapping("/{elfId}/assign/{giftId}")
    public ElfDto assignGiftToElf(
            @PathVariable Long elfId,
            @PathVariable Long giftId) {

        return elvesService.assignGiftToElf(elfId, giftId);
    }
}
