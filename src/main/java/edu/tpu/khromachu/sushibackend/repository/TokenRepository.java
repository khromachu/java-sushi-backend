package edu.tpu.khromachu.sushibackend.repository;

import edu.tpu.khromachu.sushibackend.domain.Token;
import edu.tpu.khromachu.sushibackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    void deleteAllByExpireAtBefore(LocalDate expireAt);
    Token findTokenById(UUID token);
}