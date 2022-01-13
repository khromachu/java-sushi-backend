package edu.tpu.khromachu.sushibackend.repository;

import edu.tpu.khromachu.sushibackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLoginAndPassword(String login, String password);
}