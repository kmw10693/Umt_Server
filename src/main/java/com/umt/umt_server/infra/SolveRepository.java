package com.umt.umt_server.infra;

import com.umt.umt_server.domain.Solve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolveRepository extends JpaRepository<Solve, Long> {
}
