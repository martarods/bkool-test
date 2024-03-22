package com.bkool.application.usecases;


import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.repository.BikeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateBikeTest {

    @Mock
    private BikeRepository bikeRepository;

    @InjectMocks
    private CreateBike createBike;

    @Test
    void shouldCreateBike() {
        Bike bike = mock(Bike.class);
        createBike.execute(bike);

        verify(bikeRepository).save(bike);
    }
}