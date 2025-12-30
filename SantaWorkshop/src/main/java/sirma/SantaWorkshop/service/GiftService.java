package sirma.SantaWorkshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sirma.SantaWorkshop.entity.Gift;
import sirma.SantaWorkshop.entity.dto.GiftDto;
import sirma.SantaWorkshop.entity.enums.Status;
import sirma.SantaWorkshop.repository.GiftRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GiftService {


    private final GiftRepository giftRepository;
    private final ModelMapper modelMapper;

    public GiftService(GiftRepository giftRepository, ModelMapper modelMapper) {
        this.giftRepository = giftRepository;
        this.modelMapper = modelMapper;
    }

    public GiftDto createGift(GiftDto giftDto) {

        Gift gift = modelMapper.map(giftDto, Gift.class);
        
        // Explicitly map the name if the field names differ
        if (gift.getName() == null && giftDto.getName() != null) {
            gift.setName(giftDto.getName());
        }

        gift.setWrapped(false);
        gift.setStatus(Status.PENDING);
        gift.setCreatedAt(LocalDateTime.now());

        Gift saved = giftRepository.save(gift);
        return modelMapper.map(saved, GiftDto.class);
    }

    public List<GiftDto> getAllGifts(){
        return giftRepository.findAll().stream().map(gift -> modelMapper.map(gift,GiftDto.class))
                .toList();
    }

    public GiftDto getGiftById(Long id){
        Gift gift = giftRepository.findAllById(id);
        return modelMapper.map(gift,GiftDto.class);

    }
    public GiftDto updateGift(Long id, GiftDto giftDto){
        Gift existingGift = giftRepository.findById(id).orElseThrow(() -> new RuntimeException("Gift not found"));
         LocalDateTime creationDate = existingGift.getCreatedAt();
        modelMapper.map(giftDto,existingGift);
        existingGift.setCreatedAt(creationDate);
        giftRepository.save(existingGift);

        return giftDto;
    }
    public  GiftDto getWrapped(Long id){
        Gift gift = giftRepository.findById(id).orElseThrow(() -> new RuntimeException("Gift not found"));
        gift.setWrapped(true);
        giftRepository.save(gift);
        return modelMapper.map(gift, GiftDto.class);
    }

    public void deleteGiftById(Long id){
        Gift gift = giftRepository.findById(id).orElseThrow(() -> new RuntimeException("Gift not found"));
        giftRepository.delete(gift);
    }



}
