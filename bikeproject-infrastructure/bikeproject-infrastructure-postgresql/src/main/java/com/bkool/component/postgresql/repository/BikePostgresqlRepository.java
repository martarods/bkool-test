package com.bkool.component.postgresql.repository;

import com.bkool.component.postgresql.dao.BikeDao;
import com.bkool.component.postgresql.entity.BikeEntity;
import com.bkool.component.postgresql.mapper.BikeEntityMapper;
import com.bkool.domain.entities.bike.Bike;
import com.bkool.domain.entities.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BikePostgresqlRepository implements BikeRepository {

    private final BikeDao bikeDao;

    private final BikeEntityMapper bikeEntityMapper;

    @Cacheable("bikes")
    public List<Bike> findAllBy(String name, String manufacturer, String itemType, String order) {
        Sort.Direction direction = "asc".equalsIgnoreCase(order)
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, "name");
        return bikeEntityMapper.reverseAll(bikeDao.findAllByCriteria(name, manufacturer, itemType, sort));
    }

    @CacheEvict(value = "bikes", allEntries = true)
    public Bike save(Bike bike) {
        BikeEntity entity = bikeEntityMapper.convert(bike);
        return bikeEntityMapper.reverse(bikeDao.save(entity));
    }

}
