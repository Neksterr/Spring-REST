package sirma.SantaWorkshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sirma.SantaWorkshop.entity.Delivery;
import sirma.SantaWorkshop.entity.Elf;
import sirma.SantaWorkshop.entity.Gift;
import sirma.SantaWorkshop.entity.dto.DeliveryDto;
import sirma.SantaWorkshop.entity.enums.DeliveryStatus;
import sirma.SantaWorkshop.repository.DeliveryRepository;
import sirma.SantaWorkshop.repository.ElvesRepository;
import sirma.SantaWorkshop.repository.GiftRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class DeliveryService {
    private final ElvesRepository elvesRepository;
    private final GiftRepository giftRepository;
    private final DeliveryRepository deliveryRepository;
    private ModelMapper modelMapper;

    public DeliveryService(ElvesRepository elvesRepository, GiftRepository giftRepository, DeliveryRepository deliveryRepository) {
        this.elvesRepository = elvesRepository;
        this.giftRepository = giftRepository;
        this.deliveryRepository = deliveryRepository;
    }
    public void createDelivery(DeliveryDto deliveryDto){
        Delivery newDelivery = modelMapper.map(deliveryDto, Delivery.class);
        deliveryRepository.save(newDelivery);
    }

    public List<DeliveryDto> getDeliveries(){
        return deliveryRepository.findAll().stream().map(delivery -> modelMapper.map(delivery,DeliveryDto.class)).toList();
    }

    public void createDelivery(String recipientName,
                               String address,
                               Long giftId,
                               Long elfId,
                               LocalDate deliveryDate) {

        List<Gift> gift = Collections.singletonList(giftRepository.findById(giftId)
                .orElseThrow(() -> new RuntimeException("Gift not found")));

        Elf elf = elvesRepository.findById(elfId)
                .orElseThrow(() -> new RuntimeException("Elf not found"));

        Delivery delivery = new Delivery();
        delivery.setRecipientName(recipientName);
        delivery.setAddress(address);
        delivery.setGifts(gift);
        delivery.setElf(elf);
        delivery.setEstimatedArrival(deliveryDate);

        deliveryRepository.save(delivery); // trackingCode auto-generated
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
    public List<Delivery> getDeliveriesByStatus(DeliveryStatus status) {
        return deliveryRepository.findAllByDeliveryStatus(status);
    }
}
