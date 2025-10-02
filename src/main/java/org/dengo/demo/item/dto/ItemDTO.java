package org.dengo.demo.item.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDTO {
  
  private Long itemId;
  
  private String itemName;
  
  private int price;
  
  private String itemDesc;
  
  private boolean delFlag;
  
  
  
}
