package com.bkool.application.usecases;

import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RetrieveBikes {

    private final BikeRepository bikeRepository;

    public List<Bike> execute(String name, String manufacturer, String itemType, String orderBy) {
        return bikeRepository.findAllBy(name, manufacturer, itemType, orderBy);
    }
}
