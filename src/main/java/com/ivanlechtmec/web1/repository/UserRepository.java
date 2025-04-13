package com.ivanlechtmec.web1.repository;

import com.ivanlechtmec.web1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
