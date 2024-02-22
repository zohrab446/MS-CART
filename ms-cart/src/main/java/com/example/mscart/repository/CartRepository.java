package com.example.mscart.repository;

import com.example.mscart.dto.response.CartDto;
import com.example.mscart.entity.Cart;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository <Cart,Long>{
    Cart findByCartId(Long id);
}
