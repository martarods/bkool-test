package com.bkool.component.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String type;

    private String description;


}
