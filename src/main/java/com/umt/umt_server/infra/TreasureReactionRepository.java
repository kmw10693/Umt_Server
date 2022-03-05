package com.umt.umt_server.infra;

import com.umt.umt_server.domain.Treasure;
import com.umt.umt_server.domain.TreasureReaction;
import com.umt.umt_server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreasureReactionRepository extends JpaRepository<TreasureReaction, Long> {
        boolean existsByUserAndTreasureAndReactionType(User user, Treasure treasure, String reactionType);

}
