package com.bkool.component.apirest.controller;

import com.bkool.api.BikesApi;
import com.bkool.application.usecases.CreateBike;
import com.bkool.application.usecases.RetrieveBikes;
import com.bkool.component.apirest.mapper.BikeDtoMapper;
import com.bkool.domain.entities.bike.Bike;
import com.bkool.model.BikeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BikeController implements BikesApi {

    private final BikeDtoMapper bikeDtoMapper;

    private final CreateBike createBike;

    private final RetrieveBikes retrieveBikes;

    @Override
    public ResponseEntity<Void> createBike(BikeDTO bikeDTO) {
        createBike.execute(bikeDtoMapper.reverse(bikeDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<BikeDTO>> findBike(String name, String manufacturer, String itemType, String orderBy) {
        List<Bike> result = retrieveBikes.execute(name, manufacturer, itemType, orderBy);
        return ResponseEntity.ok(bikeDtoMapper.convertAll(result));
    }
}
