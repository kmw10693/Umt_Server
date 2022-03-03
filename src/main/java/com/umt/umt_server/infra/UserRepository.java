package com.umt.umt_server.infra;

import com.umt.umt_server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 리포지토리 파일 입니다.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
