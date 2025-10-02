package org.dengo.demo.item.service;

import org.dengo.demo.item.dto.ItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceImplTests {
  
  @Autowired
  private ItemService itemService;
  
  @Test
  void register() {
    ItemDTO itemDTO = ItemDTO.builder()
        .itemName("test")
        .itemDesc("testDesc")
        .price(1000)
        .build();
    itemService.register(itemDTO);
    
  }
  
}