package com.bkool.application.usecases;

import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateBike {

    private final BikeRepository bikeRepository;

    public void execute(Bike bike) {
        bikeRepository.save(bike);
    }


}
