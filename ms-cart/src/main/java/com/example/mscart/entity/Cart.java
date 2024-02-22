package com.example.mscart.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Entity
@Data
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    @Id
    Long cartId;
    Long userId;
    @OneToMany
    List <Item> cartItemIds;

    public void clearItems() {
    }

    public void add(Item item) {
    }
}
