package sirma.SantaWorkshop.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sirma.SantaWorkshop.entity.Elf;
import sirma.SantaWorkshop.entity.Gift;
import sirma.SantaWorkshop.entity.enums.Category;
import sirma.SantaWorkshop.entity.enums.SkillLevel;
import sirma.SantaWorkshop.entity.enums.Status;
import sirma.SantaWorkshop.repository.GiftRepository;
import sirma.SantaWorkshop.repository.ElvesRepository;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initElves(ElvesRepository elvesRepository) {
        return args -> {

            if (elvesRepository.count() > 0) {
                return; // avoid duplicate inserts
            }

            Elf elf1 = new Elf();
            elf1.setName("Buddy");
            elf1.setSkillLevel(SkillLevel.JUNIOR);

            Elf elf2 = new Elf();
            elf2.setName("Jingle");
            elf2.setSkillLevel(SkillLevel.MID);

            Elf elf3 = new Elf();
            elf3.setName("Snowflake");
            elf3.setSkillLevel(SkillLevel.SENIOR);

            elvesRepository.saveAll(
                    List.of(elf1, elf2, elf3)
            );
        };
    }


    @Bean
    CommandLineRunner initGifts(GiftRepository giftRepository) {
        return args -> {

            if (giftRepository.count() > 0) {
                return; // avoid duplicate inserts
            }

            Gift gift1 = new Gift();
            gift1.setName("Teddy Bear");
            gift1.setCategory(Category.TOY);
            gift1.setTargetAge(5);
            gift1.setWrapped(true);
            gift1.setStatus(Status.READY);
            gift1.setCreatedAt(LocalDateTime.now().minusDays(2));

            Gift gift2 = new Gift();
            gift2.setName("Harry Potter Book");
            gift2.setCategory(Category.BOOK);
            gift2.setTargetAge(10);
            gift2.setWrapped(false);
            gift2.setStatus(Status.PENDING);
            gift2.setCreatedAt(LocalDateTime.now().minusDays(1));

            Gift gift3 = new Gift();
            gift3.setName("Smart Watch");
            gift3.setCategory(Category.GADGET);
            gift3.setTargetAge(12);
            gift3.setWrapped(true);
            gift3.setStatus(Status.LOADED);
            gift3.setCreatedAt(LocalDateTime.now());

            giftRepository.saveAll(
                    List.of(gift1, gift2, gift3)
            );
        };
    }
}
