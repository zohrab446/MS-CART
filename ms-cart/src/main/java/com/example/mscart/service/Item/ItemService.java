package com.example.mscart.service.Item;

import com.example.mscart.dto.request.item.CreateItemRequest;
import com.example.mscart.dto.request.item.UpdateItemRequest;
import com.example.mscart.dto.response.ItemDto;
import com.example.mscart.entity.Item;
import com.example.mscart.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class ItemService implements ItemServiceInter {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    @Override
    public void createItemRequest(CreateItemRequest createItemRequest) {
        Item item=Item.builder()
                .itemId(Long.valueOf(createItemRequest.getItemId()))
                .productId(Long.valueOf(createItemRequest.getProductId()))
                .quantity(createItemRequest.getQuantity())
                .build();
        itemRepository.save(item);
    }

    @Override
    public ItemDto findById(Long id) {
        Item item= itemRepository.findByItemId(id);
        ItemDto itemDto = modelMapper.map(item,ItemDto.class);
        return itemDto;
    }

    @Override
    public void deleteItem(Long id) {
        Item item=itemRepository.findByItemId(id);
        itemRepository.delete(item);
    }

    @Override
    public ItemDto updateItem(Long id, UpdateItemRequest updateItemRequest) {
        Item item=itemRepository.findByItemId(id);
        item.setItemId(Long.valueOf(updateItemRequest.getItemId()));
        item.setItemId(Long.valueOf(updateItemRequest.getItemId()));
        item.setQuantity(updateItemRequest.getQuantity());
        itemRepository.save(item);
        return modelMapper.map(item,ItemDto.class);
    }

    @Override
    public List<ItemDto> getAll() {
        return null;
    }
}
