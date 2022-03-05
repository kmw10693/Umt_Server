package com.umt.umt_server.application;

import com.umt.umt_server.domain.Quest;
import com.umt.umt_server.domain.Solve;
import com.umt.umt_server.domain.Treasure;
import com.umt.umt_server.domain.User;
import com.umt.umt_server.dto.ReactionReq;
import com.umt.umt_server.dto.SolveReq;
import com.umt.umt_server.dto.SolveRes;
import com.umt.umt_server.errors.CustomException;
import com.umt.umt_server.errors.ErrorCode;
import com.umt.umt_server.infra.QuestRepository;
import com.umt.umt_server.infra.SolveRepository;
import com.umt.umt_server.infra.TreasureRepository;
import com.umt.umt_server.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SolveService {
    private final SolveRepository solveRepository;
    private final QuestRepository questRepository;
    private final TreasureRepository treasureRepository;
    private final UserRepository userRepository;

    public SolveRes createSolve(SolveReq solveReq) {
        Optional<Treasure> treasure = treasureRepository.findById(solveReq.getTreasureId());
        Optional<Quest> quest = questRepository.findByTreasure(treasure);

        User user = userRepository.getById(solveReq.getUserId());

        if(quest.get().getAnswerIndex() != solveReq.getAnswer()) {
            throw new CustomException(ErrorCode.NOT_MATCH_ANSWER);
        }

        solveRepository.save(
                Solve.builder()
                        .user(user)
                        .quest(quest.get())
                        .build()
        );

        return SolveRes.builder()
                .treasureId(treasure.get().getId())
                .photoUrl(treasure.get().getPhotoUrl())
                .likeCnt(15)
                .dislikeCnt(3)
                .hashTag(treasure.get().getHashTag())
                .text(treasure.get().getText())
                .build();
    }
}
