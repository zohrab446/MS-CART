package com.example.mscart.dto.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto implements Serializable {
    @Id
    Long itemId;
    String productId;
    int quantity;
}
