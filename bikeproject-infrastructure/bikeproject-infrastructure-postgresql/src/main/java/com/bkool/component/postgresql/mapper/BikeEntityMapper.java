package com.bkool.component.postgresql.mapper;

import com.bkool.component.postgresql.entity.BikeEntity;
import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.bike.BikeBuilder;
import com.bkool.domain.entities.bike.BikeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BikeEntityMapper {

    private final ItemEntityMapper itemEntityMapper;

    public BikeEntity convert(Bike bike) {
        return BikeEntity.builder()
                .id(bike.getId().getIdentifier())
                .name(bike.getName())
                .description(bike.getDescription())
                .price(bike.getPrice())
                .manufacturer(bike.getManufacturer())
                .items(itemEntityMapper.convertAll(bike.getItems()))
                .build();
    }

    public List<BikeEntity> convertAll(List<Bike> bikes) {
        return bikes.stream()
                .map(this::convert)
                .toList();

    }

    public Bike reverse(BikeEntity dto) {
        return BikeBuilder.builder()
                .id(new BikeId(dto.getId()))
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .manufacturer(dto.getManufacturer())
                .items(itemEntityMapper.reverseAll(dto.getItems()))
                .build();
    }

    public List<Bike> reverseAll(List<BikeEntity> bikes) {
        return bikes.stream()
                .map(this::reverse)
                .toList();

    }
}
