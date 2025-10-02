package org.dengo.demo.item.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dengo.demo.item.dto.ItemDTO;
import org.dengo.demo.item.entity.Item;
import org.dengo.demo.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
  
  private final ItemRepository itemRepository;
  
  @Override
  public Long register(ItemDTO itemDTO) {
    Item item = DTOtoEntity(itemDTO);
    Long itemId = itemRepository.save(item).getItemId();
    return itemId;
    
  }
}
