package com.bkool.component.apirest.mapper;

import com.bkool.domain.entities.item.Item;
import com.bkool.domain.entities.item.ItemBuilder;
import com.bkool.domain.entities.item.ItemId;
import com.bkool.model.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemDtoMapper {

    public ItemDTO convert(Item item) {
        return new ItemDTO()
                .id(item.getId().getIdentifier())
                .model(item.getModel())
                .type(item.getType())
                .description(item.getDescription());
    }

    public List<ItemDTO> convertAll(List<Item> items) {
        return items.stream()
                .map(this::convert)
                .toList();
    }

    public Item reverse(ItemDTO dto) {
        return ItemBuilder.builder()
                .id(new ItemId(dto.getId()))
                .model(dto.getModel())
                .type(dto.getType())
                .description(dto.getDescription())
                .build();
    }

    public List<Item> reverseAll(List<ItemDTO> items) {
        return items.stream()
                .map(this::reverse)
                .toList();
    }
}
