package com.bkool.component.apirest.mapper;


import com.bkool.domain.entities.item.Item;
import com.bkool.domain.entities.item.ItemBuilder;
import com.bkool.domain.entities.item.ItemId;
import com.bkool.model.ItemDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ItemDtoMapperTest {

    private final ItemDtoMapper itemDtoMapper = new ItemDtoMapper();

    @Test
    void shouldConvertItemDomainEntityToDto() {
        Item item = ItemBuilder.builder()
                .id(new ItemId(1L))
                .model("item model")
                .type("item type")
                .description("item desc")
                .build();

        ItemDTO itemDTO = itemDtoMapper.convert(item);

        assertThat(itemDTO.getId()).isEqualTo(item.getId().getIdentifier());
        assertThat(itemDTO.getModel()).isEqualTo(item.getModel());
        assertThat(itemDTO.getType()).isEqualTo(item.getType());
        assertThat(itemDTO.getDescription()).isEqualTo(item.getDescription());
    }

    @Test
    void shouldConvertAllItemDomainEntitiesToDtos() {
        Item item = ItemBuilder.builder()
                .id(new ItemId(1L))
                .model("item model")
                .type("item type")
                .description("item desc")
                .build();

        List<ItemDTO> itemDTOS = itemDtoMapper.convertAll(List.of(item));

        assertThat(itemDTOS).hasSize(1);
        ItemDTO itemDTO = itemDTOS.get(0);
        assertThat(itemDTO.getId()).isEqualTo(item.getId().getIdentifier());
        assertThat(itemDTO.getModel()).isEqualTo(item.getModel());
        assertThat(itemDTO.getType()).isEqualTo(item.getType());
        assertThat(itemDTO.getDescription()).isEqualTo(item.getDescription());
    }

    @Test
    void shouldConvertItemDtoToDomainEntity() {
        ItemDTO itemDTO = new ItemDTO()
                .id(1L)
                .model("item model")
                .type("item type")
                .description("item desc");

        Item item = itemDtoMapper.reverse(itemDTO);

        assertThat(itemDTO.getId()).isEqualTo(item.getId().getIdentifier());
        assertThat(itemDTO.getModel()).isEqualTo(item.getModel());
        assertThat(itemDTO.getType()).isEqualTo(item.getType());
        assertThat(itemDTO.getDescription()).isEqualTo(item.getDescription());
    }

    @Test
    void shouldConvertAllItemDtosToDomainEntities() {
        ItemDTO itemDTO = new ItemDTO()
                .id(1L)
                .model("item model")
                .type("item type")
                .description("item desc");

        List<Item> items = itemDtoMapper.reverseAll(List.of(itemDTO));

        assertThat(items).hasSize(1);
        Item item = items.get(0);
        assertThat(itemDTO.getId()).isEqualTo(item.getId().getIdentifier());
        assertThat(itemDTO.getModel()).isEqualTo(item.getModel());
        assertThat(itemDTO.getType()).isEqualTo(item.getType());
        assertThat(itemDTO.getDescription()).isEqualTo(item.getDescription());
    }

}