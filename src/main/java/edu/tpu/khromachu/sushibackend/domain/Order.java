package edu.tpu.khromachu.sushibackend.domain;

import edu.tpu.khromachu.sushibackend.domain.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "clientName", nullable = false)
    private String clientName;

    @Column(name = "clientPhone", nullable = false)
    private String clientPhone;

    @Column(name = "createdAt", nullable = false)
    @CreatedDate
    private OffsetDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    @LastModifiedDate
    private OffsetDateTime updatedAt;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private User clientId;

    public User getClientId() {
        return clientId;
    }

    public void setClientId(User clientId) {
        this.clientId = clientId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}