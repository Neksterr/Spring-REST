package sirma.SantaWorkshop.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sirma.SantaWorkshop.entity.Gift;
import sirma.SantaWorkshop.entity.dto.GiftDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(GiftDto.class, Gift.class)
                .addMapping(GiftDto::getName, Gift::setName);

        return modelMapper;
    }
}
