package com.bkool.domain.entities.bike;

import com.bkool.domain.entities.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BikeBuilder {
    private BikeId id;
    private String name;
    private String description;
    private Float price;
    private String manufacturer;
    private List<Item> items;

    public BikeBuilder() {
    }

    public static BikeBuilder builder() {
        return new BikeBuilder();
    }

    public BikeBuilder id(BikeId id) {
        this.id = id;
        return this;
    }

    public BikeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BikeBuilder description(String description) {
        this.description = description;
        return this;
    }

    public BikeBuilder price(Float price) {
        this.price = price;
        return this;
    }

    public BikeBuilder manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public BikeBuilder items(List<Item> items) {
        this.items = items;
        return this;
    }

    public Bike build() {
        if (id == null) {
            throw new IllegalStateException("Id is required");
        }
        if (name == null) {
            throw new IllegalStateException("Name is required");
        }
        return new Bike(id, name, description, price, manufacturer, items);
    }
}
