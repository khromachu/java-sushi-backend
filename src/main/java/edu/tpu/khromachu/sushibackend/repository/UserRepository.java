package edu.tpu.khromachu.sushibackend.repository;

import edu.tpu.khromachu.sushibackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}