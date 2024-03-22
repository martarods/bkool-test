package com.bkool.component.postgresql.repository;


import com.bkool.component.postgresql.dao.BikeDao;
import com.bkool.component.postgresql.entity.BikeEntity;
import com.bkool.component.postgresql.mapper.BikeEntityMapper;
import com.bkool.domain.entities.bike.Bike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BikePostgresqlRepositoryTest {
    @Mock
    private BikeDao bikeDao;
    @Mock
    private BikeEntityMapper bikeEntityMapper;

    @InjectMocks
    private BikePostgresqlRepository bikePostgresqlRepository;

    @Test
    void shouldFindAllByCriteriaOrderAsc() {
        List<BikeEntity> bikesEntity = List.of(mock(BikeEntity.class));
        List<Bike> bikes = List.of(mock(Bike.class));
        when(bikeEntityMapper.reverseAll(bikesEntity)).thenReturn(bikes);
        when(bikeDao.findAllByCriteria("name", "manufacturer", "frame", Sort.by(Sort.Direction.ASC, "name")))
                .thenReturn(bikesEntity);

        List<Bike> bikesResult = bikePostgresqlRepository.findAllBy("name", "manufacturer", "frame", "asc");

        assertThat(bikesResult).isEqualTo(bikes);
    }

    @Test
    void shouldFindAllByCriteriaOrderDesc() {
        List<BikeEntity> bikesEntity = List.of(mock(BikeEntity.class));
        List<Bike> bikes = List.of(mock(Bike.class));
        when(bikeEntityMapper.reverseAll(bikesEntity)).thenReturn(bikes);
        when(bikeDao.findAllByCriteria("name", "manufacturer", "frame", Sort.by(Sort.Direction.DESC, "name")))
                .thenReturn(bikesEntity);

        List<Bike> bikesResult = bikePostgresqlRepository.findAllBy("name", "manufacturer", "frame", "desc");

        assertThat(bikesResult).isEqualTo(bikes);
    }
}