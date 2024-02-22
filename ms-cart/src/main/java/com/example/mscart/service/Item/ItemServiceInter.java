package com.example.mscart.service.Item;

import com.example.mscart.dto.request.item.CreateItemRequest;
import com.example.mscart.dto.request.item.UpdateItemRequest;
import com.example.mscart.dto.response.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemServiceInter {
    void createItemRequest(CreateItemRequest createItemRequest);

    ItemDto findById(Long id);

    void deleteItem(Long id);

    ItemDto updateItem(Long id, UpdateItemRequest updateItemRequest);

    List<ItemDto> getAll();
}
