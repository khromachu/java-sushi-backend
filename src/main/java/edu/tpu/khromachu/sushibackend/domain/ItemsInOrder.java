package edu.tpu.khromachu.sushibackend.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ItemsInOrders")
public class ItemsInOrder {
    @EmbeddedId
    private ItemsInOrderId id;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "count", nullable = false)
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public ItemsInOrderId getId() {
        return id;
    }

    public void setId(ItemsInOrderId id) {
        this.id = id;
    }
}