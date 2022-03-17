package com.umt.umt_server.infra;

import com.umt.umt_server.domain.Solve;
import com.umt.umt_server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolveRepository extends JpaRepository<Solve, Long> {

    @Query("select count(s.id) from Solve s where s.user = :user")
    Long CountByUser(User user);
}
