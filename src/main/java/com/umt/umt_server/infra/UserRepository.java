package com.umt.umt_server.infra;

import com.umt.umt_server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
