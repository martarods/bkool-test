package com.bkool.domain.entities.item;

public class ItemId {
    private final Long identifier;

    public ItemId(Long identifier) {
        this.identifier = identifier;
    }

    public Long getIdentifier() {
        return identifier;
    }
}
