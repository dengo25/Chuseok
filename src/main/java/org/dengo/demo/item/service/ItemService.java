package org.dengo.demo.item.service;

import org.dengo.demo.item.dto.ItemDTO;
import org.dengo.demo.item.entity.Item;

import java.util.List;

public interface ItemService  {
  
  Long register(ItemDTO itemDTO);
  
  
  default Item DTOtoEntity(ItemDTO itemDTO) {
    Item item = Item.builder()
        .itemId(itemDTO.getItemId())
        .itemName(itemDTO.getItemName())
        .itemDesc(itemDTO.getItemDesc())
        .price(itemDTO.getPrice())
        .build();
    
    return item;
  }
  
  default ItemDTO entityToDTO(Item item) {
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
