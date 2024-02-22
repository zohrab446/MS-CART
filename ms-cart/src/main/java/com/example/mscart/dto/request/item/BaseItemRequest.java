package com.example.mscart.dto.request.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseItemRequest {
    long itemId;
    long productId;
    int quantity;
}
