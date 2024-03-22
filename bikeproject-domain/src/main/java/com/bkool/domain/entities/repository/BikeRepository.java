package com.bkool.domain.entities.repository;

import com.bkool.domain.entities.bike.Bike;

import java.util.List;

public interface BikeRepository {
    List<Bike> findAllBy(String name, String manufacturer, String itemType, String orderBy);

    Bike save(Bike bike);
}
