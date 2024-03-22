package com.bkool.application.usecases;

import com.bkool.domain.entities.repository.BikeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RetrieveBikesTest {

    @Mock
    private BikeRepository bikeRepository;

    @InjectMocks
    private RetrieveBikes retrieveBikes;

    @Test
    void shouldRetrieveBikes() {
        retrieveBikes.execute("name", "manufacturer", "frame", "asc");
        verify(bikeRepository).findAllBy("name", "manufacturer", "frame", "asc");
    }
}