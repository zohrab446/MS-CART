package com.example.mscart.repository;

import com.example.mscart.entity.Cart;
import com.example.mscart.entity.Item;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item,Long>{
    Item findByItemId(Long id);
}
