package org.dengo.demo.item.repository;

import org.dengo.demo.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {


}
