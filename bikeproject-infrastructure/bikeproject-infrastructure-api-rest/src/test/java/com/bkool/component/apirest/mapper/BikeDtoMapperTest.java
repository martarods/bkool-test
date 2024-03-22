package com.bkool.component.apirest.mapper;


import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.bike.BikeBuilder;
import com.bkool.domain.entities.bike.BikeId;
import com.bkool.model.BikeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BikeDtoMapperTest {

    private final ItemDtoMapper itemDtoMapper = new ItemDtoMapper();

    private final BikeDtoMapper bikeDtoMapper = new BikeDtoMapper(itemDtoMapper);

    @Test
    void shouldConvertBikeDomainEntityToDto() {
        Bike bike = BikeBuilder.builder()
                .id(new BikeId(1L))
                .name("bike name")
                .description("bike desc")
                .price(99.99f)
                .manufacturer("bike manufacturer")
                .items(List.of())
                .build();

        BikeDTO bikeDTO = bikeDtoMapper.convert(bike);

        assertThat(bikeDTO.getId()).isEqualTo(bike.getId().getIdentifier());
        assertThat(bikeDTO.getName()).isEqualTo(bike.getName());
        assertThat(bikeDTO.getDescription()).isEqualTo(bike.getDescription());
        assertThat(bikeDTO.getPrice()).isEqualTo(bike.getPrice());
        assertThat(bikeDTO.getManufacturer()).isEqualTo(bike.getManufacturer());
        assertThat(bikeDTO.getItems()).isEmpty();
    }

    @Test
    void shouldConvertAllBikeDomainEntitiesToDtos() {
        Bike bike = BikeBuilder.builder()
                .id(new BikeId(1L))
                .name("bike name")
                .description("bike desc")
                .price(99.99f)
                .manufacturer("bike manufacturer")
                .items(List.of())
                .build();

        List<BikeDTO> bikeDTOS = bikeDtoMapper.convertAll(List.of(bike));

        assertThat(bikeDTOS).hasSize(1);
        BikeDTO bikeDTO = bikeDTOS.get(0);
        assertThat(bikeDTO.getId()).isEqualTo(bike.getId().getIdentifier());
        assertThat(bikeDTO.getName()).isEqualTo(bike.getName());
        assertThat(bikeDTO.getDescription()).isEqualTo(bike.getDescription());
        assertThat(bikeDTO.getPrice()).isEqualTo(bike.getPrice());
        assertThat(bikeDTO.getManufacturer()).isEqualTo(bike.getManufacturer());
        assertThat(bikeDTO.getItems()).isEmpty();
    }

    @Test
    void shouldConvertBikeDtoToDomainEntity() {
        BikeDTO bikeDTO = new BikeDTO()
                .id(1L)
                .name("bike name")
                .description("bike desc")
                .price(99.99f)
                .manufacturer("bike manufacturer")
                .items(List.of());

        Bike bike = bikeDtoMapper.reverse(bikeDTO);

        assertThat(bikeDTO.getId()).isEqualTo(bike.getId().getIdentifier());
        assertThat(bikeDTO.getName()).isEqualTo(bike.getName());
        assertThat(bikeDTO.getDescription()).isEqualTo(bike.getDescription());
        assertThat(bikeDTO.getPrice()).isEqualTo(bike.getPrice());
        assertThat(bikeDTO.getManufacturer()).isEqualTo(bike.getManufacturer());
        assertThat(bikeDTO.getItems()).isEmpty();
    }
}