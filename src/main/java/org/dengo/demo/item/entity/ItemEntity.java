package org.dengo.demo.item.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "items")
public class ItemEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
