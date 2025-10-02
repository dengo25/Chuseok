package org.dengo.demo.item.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "items")
@Builder
public class Item {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long itemId;
  
  private String itemName;
  
  private String itemDesc;
  
  private int price;
  
  private boolean delFlag;
  
  @CreationTimestamp
  private LocalDateTime createdAt;
}
