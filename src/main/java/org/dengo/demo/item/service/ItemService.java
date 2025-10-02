package org.dengo.demo.item.service;

import org.dengo.demo.item.dto.ItemDTO;
import org.dengo.demo.item.entity.ItemEntity;

public interface ItemService  {
  
  Long register(ItemDTO itemDTO);
  
  
  default ItemEntity DTOtoEntity(ItemDTO itemDTO) {
    ItemEntity item = ItemEntity.builder()
        .itemId(itemDTO.getItemId())
        .itemName(itemDTO.getItemName())
        .itemDesc(itemDTO.getItemDesc())
        .price(itemDTO.getPrice())
        .build();
    
    return item;
  }
  
  default ItemDTO entityToDTO(ItemEntity item) {
    ItemDTO itemDTO = ItemDTO.builder()
        .itemId(item.getItemId())
        .itemDesc(item.getItemDesc())
        .itemName(item.getItemName())
        .price(item.getPrice())
        .delFlag(item.isDelFlag())
        .build();
    
    return itemDTO;
  }
}
