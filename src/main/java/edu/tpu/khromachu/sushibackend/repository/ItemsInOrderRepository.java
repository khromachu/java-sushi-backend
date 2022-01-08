package edu.tpu.khromachu.sushibackend.repository;

import edu.tpu.khromachu.sushibackend.domain.ItemsInOrder;
import edu.tpu.khromachu.sushibackend.domain.ItemsInOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsInOrderRepository extends JpaRepository<ItemsInOrder, ItemsInOrderId> {
}