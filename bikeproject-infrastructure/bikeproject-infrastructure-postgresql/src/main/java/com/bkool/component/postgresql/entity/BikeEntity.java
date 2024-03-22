package com.bkool.component.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bikes")
public class BikeEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private Float price;

    @Column
    private String manufacturer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bike_item",
            joinColumns = @JoinColumn(name = "bike_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> items;

}
