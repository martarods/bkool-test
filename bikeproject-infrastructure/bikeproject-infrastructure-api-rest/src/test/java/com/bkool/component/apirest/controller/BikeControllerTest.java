package com.bkool.component.apirest.controller;


import com.bkool.application.usecases.CreateBike;
import com.bkool.application.usecases.RetrieveBikes;
import com.bkool.component.apirest.mapper.BikeDtoMapper;
import com.bkool.domain.entities.bike.Bike;
import com.bkool.model.BikeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BikeControllerTest {
    @Mock
    private BikeDtoMapper bikeDtoMapper;
    @Mock
    private CreateBike createBike;
    @Mock
    private RetrieveBikes retrieveBikes;

    @InjectMocks
    private BikeController bikeController;


    @Test
    void shouldCreateBike() {
        BikeDTO bikeDTO = mock(BikeDTO.class);
        Bike bike = mock(Bike.class);
        when(bikeDtoMapper.reverse(bikeDTO)).thenReturn(bike);

        ResponseEntity<Void> response = bikeController.createBike(bikeDTO);

        verify(createBike).execute(bike);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
    }

    @Test
    void shouldFindBike() {
        List<Bike> bikes = List.of(mock(Bike.class));
        List<BikeDTO> bikeDTOS = List.of(mock(BikeDTO.class));
        when(bikeDtoMapper.convertAll(bikes)).thenReturn(bikeDTOS);
        when(retrieveBikes.execute("name", "manufacturer", "frame", "asc")).thenReturn(bikes);

        ResponseEntity<List<BikeDTO>> response = bikeController.findBike("name", "manufacturer", "frame", "asc");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(response.getBody()).isEqualTo(bikeDTOS);
    }
}