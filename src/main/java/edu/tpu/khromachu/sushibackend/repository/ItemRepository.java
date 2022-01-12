package edu.tpu.khromachu.sushibackend.repository;

import edu.tpu.khromachu.sushibackend.domain.Item;
import edu.tpu.khromachu.sushibackend.domain.ItemType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {
    Page<Item> findAllByItemTypeIdOrderByName(ItemType itemTypeId, Pageable pageable);
    Page<Item> findAllByItemTypeIdAndShowTrueOrderByName(ItemType itemTypeId, Pageable pageable);
}