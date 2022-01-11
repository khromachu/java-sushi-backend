package edu.tpu.khromachu.sushibackend.domain;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemsInOrderId implements Serializable {
    private static final long serialVersionUID = 1743109862776444506L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "itemId", nullable = false)
    private Item itemId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "orderId", nullable = false)
    private Order orderId;

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, orderId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemsInOrderId entity = (ItemsInOrderId) o;
        return Objects.equals(this.itemId, entity.itemId) &&
                Objects.equals(this.orderId, entity.orderId);
    }
}