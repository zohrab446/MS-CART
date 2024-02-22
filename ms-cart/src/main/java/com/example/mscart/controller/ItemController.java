package com.example.mscart.controller;
import com.example.mscart.dto.request.item.CreateItemRequest;
import com.example.mscart.dto.request.item.UpdateItemRequest;
import com.example.mscart.dto.response.ItemDto;
import com.example.mscart.service.Item.ItemServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Brend",method = RequestMethod.PUT)
@RequiredArgsConstructor
public class ItemController {
    private final ItemServiceInter itemServiceInter;

    @PutMapping("/createItem")
    public void createItem(@RequestBody CreateItemRequest item){
        itemServiceInter.createItemRequest(item);
    }
    @GetMapping("/findItem/{id}")
    public ItemDto findByItemID(@PathVariable long id){
        return itemServiceInter.findById((long) id);
    }

    @DeleteMapping("/removeItem/{id}")
    public void deleteItem(@PathVariable int id){
        itemServiceInter.deleteItem((long)id);
    }

    @PatchMapping("/updateItem/{id}")
    public ItemDto updateItem(@PathVariable int id, @RequestBody UpdateItemRequest updateItemRequest){
        return itemServiceInter.updateItem((long)id,updateItemRequest);
    }
    @GetMapping("/listItem")
    public List<ItemDto> getAll(){
        return itemServiceInter.getAll();
    }


}
