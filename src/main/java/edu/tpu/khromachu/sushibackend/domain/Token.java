package edu.tpu.khromachu.sushibackend.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Tokens")
public class Token {
    @Id
    @Column(name = "token", nullable = false)
    private UUID id;

    @Column(name = "expireAt")
    private LocalDate expireAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public LocalDate getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDate expireAt) {
        this.expireAt = expireAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}