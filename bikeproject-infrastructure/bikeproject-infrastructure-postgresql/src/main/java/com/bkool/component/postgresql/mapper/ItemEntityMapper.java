package com.bkool.component.postgresql.mapper;

import com.bkool.component.postgresql.entity.ItemEntity;
import com.bkool.domain.entities.item.Item;
import com.bkool.domain.entities.item.ItemBuilder;
import com.bkool.domain.entities.item.ItemId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemEntityMapper {
    public ItemEntity convert(Item item) {
        return ItemEntity.builder()
                .id(item.getId().getIdentifier())
                .model(item.getModel())
                .type(item.getType())
                .description(item.getDescription())
                .build();
    }

    public List<ItemEntity> convertAll(List<Item> items) {
        return items.stream()
                .map(this::convert)
                .toList();
    }

    public Item reverse(ItemEntity dto) {
        return ItemBuilder.builder()
                .id(new ItemId(dto.getId()))
                .model(dto.getModel())
                .type(dto.getType())
                .description(dto.getDescription())
                .build();
    }

    public List<Item> reverseAll(List<ItemEntity> items) {
        return items.stream()
                .map(this::reverse)
                .toList();
    }
}
