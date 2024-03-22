package com.bkool.domain.entities.item;

public class ItemBuilder {
    private ItemId id;
    private String model;
    private String type;
    private String description;

    public ItemBuilder() {
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public ItemBuilder id(ItemId id) {
        this.id = id;
        return this;
    }

    public ItemBuilder model(String model) {
        this.model = model;
        return this;
    }

    public ItemBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ItemBuilder description(String description) {
        this.description = description;
        return this;
    }

    public Item build() {
        if (id == null) {
            throw new IllegalStateException("Id is required");
        }
        if (model == null) {
            throw new IllegalStateException("Model is required");
        }
        if (type == null) {
            throw new IllegalStateException("Type is required");
        }
        return new Item(id, model, type, description);
    }
}
