package com.bkool.domain.entities.bike;

import com.bkool.domain.entities.item.Item;

import java.util.List;

public class Bike {
    private final BikeId id;

    private final String name;

    private final String description;
    private final Float price;
    private final String manufacturer;

    private final List<Item> items;

    public Bike(BikeId id, String name, String description, Float price, String manufacturer, List<Item> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.items = items;
    }

    public BikeId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public List<Item> getItems() {
        return items;
    }
}
