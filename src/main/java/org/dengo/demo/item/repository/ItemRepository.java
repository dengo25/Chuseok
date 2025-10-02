package org.dengo.demo.item.repository;

import org.dengo.demo.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {


}
