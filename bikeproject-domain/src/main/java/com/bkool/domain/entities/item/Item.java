package com.bkool.domain.entities.item;

public class Item {

    private final ItemId id;

    private final String model;

    private final String type;

    private final String description;

    public Item(ItemId id, String model, String type, String description) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.description = description;
    }

    public ItemId getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
