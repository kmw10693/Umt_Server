package com.umt.umt_server.infra;

import com.umt.umt_server.domain.Quest;
import com.umt.umt_server.domain.Treasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestRepository extends JpaRepository<Quest, Long> {

    Optional<Quest> findByTreasure(Optional<Treasure> treasure);

}
