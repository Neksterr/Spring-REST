package sirma.SantaWorkshop.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sirma.SantaWorkshop.entity.Elf;
import sirma.SantaWorkshop.entity.Gift;
import sirma.SantaWorkshop.entity.dto.ElfDto;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;
import sirma.SantaWorkshop.entity.enums.SkillLevel;
import sirma.SantaWorkshop.repository.ElvesRepository;
import org.springframework.stereotype.Service;
import sirma.SantaWorkshop.repository.GiftRepository;

import java.util.List;

@Service
public class ElvesService {
    @Autowired
    private final ElvesRepository elvesRepository;
    @Autowired
    private final GiftRepository giftRepository;
    private final ModelMapper modelMapper;

    public ElvesService(ElvesRepository elvesRepository, GiftRepository giftRepository, ModelMapper modelMapper) {
        this.elvesRepository = elvesRepository;
        this.giftRepository = giftRepository;
        this.modelMapper = modelMapper;
    }


    public ElfDto createElf(ElfDto elfDto){
        Elf newElf = modelMapper.map(elfDto, Elf.class);
        elvesRepository.save(newElf);
        return elfDto;
    }

    public List<ElfDto> getAllElves(){
        return elvesRepository.findAll().stream().map(elf -> modelMapper.map(elf,ElfDto.class))
                .toList();
    }

    public ElfDto getElfById(Long id){
        Elf elf = elvesRepository.findAllById(id);
        return modelMapper.map(elf,ElfDto.class);

    }
    public void updateElf(Long id, ElfDto elfDto){
        Elf existingElf = elvesRepository.findById(id).orElseThrow(() -> new RuntimeException("Elf not found"));

        modelMapper.map(elfDto,existingElf);
        elvesRepository.save(existingElf);

    }

    public void deleteElfById(Long id){
        Elf elf = elvesRepository.findById(id).orElseThrow(() -> new RuntimeException("Elf not found"));
        elvesRepository.delete(elf);
    }

    public void createElf(String elfName, SkillLevel elfLevel) {
    }

    public ElfDto assignGiftToElf(Long elfId, Long giftId) {


        Elf elf = elvesRepository.findById(elfId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Elf not found"));

        Gift gift = giftRepository.findById(giftId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Gift not found"));

        giftRepository.save(gift);

        return modelMapper.map(elf, ElfDto.class);
    }
}


