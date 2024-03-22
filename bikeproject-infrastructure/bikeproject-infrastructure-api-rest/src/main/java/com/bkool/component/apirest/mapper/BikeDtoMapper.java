package com.bkool.component.apirest.mapper;

import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.bike.BikeBuilder;
import com.bkool.domain.entities.bike.BikeId;
import com.bkool.model.BikeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BikeDtoMapper {

    private final ItemDtoMapper itemDtoMapper;

    public BikeDTO convert(Bike bike) {
        return new BikeDTO()
                .id(bike.getId().getIdentifier())
                .name(bike.getName())
                .description(bike.getDescription())
                .price(bike.getPrice())
                .manufacturer(bike.getManufacturer())
                .items(itemDtoMapper.convertAll(bike.getItems()));
    }

    public List<BikeDTO> convertAll(List<Bike> bikes) {
        return bikes.stream()
                .map(this::convert)
                .toList();
    }

    public Bike reverse(BikeDTO dto) {
        return BikeBuilder.builder()
                .id(new BikeId(dto.getId()))
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .manufacturer(dto.getManufacturer())
                .items(itemDtoMapper.reverseAll(dto.getItems()))
                .build();
    }

}
