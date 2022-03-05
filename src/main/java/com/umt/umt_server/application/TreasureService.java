package com.umt.umt_server.application;

import com.umt.umt_server.domain.Quest;
import com.umt.umt_server.domain.Treasure;
import com.umt.umt_server.domain.TreasureReaction;
import com.umt.umt_server.domain.User;
import com.umt.umt_server.dto.*;
import com.umt.umt_server.errors.CustomException;
import com.umt.umt_server.errors.ErrorCode;
import com.umt.umt_server.infra.QuestRepository;
import com.umt.umt_server.infra.TreasureReactionRepository;
import com.umt.umt_server.infra.TreasureRepository;
import com.umt.umt_server.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TreasureService {

    private final TreasureRepository treasureRepository;
    private final UserRepository userRepository;
    private final QuestRepository questRepository;
    private final TreasureReactionRepository treasureReactionRepository;


    public TreasureCreateRes createTreasure(TreasureCreateReq treasureRegistrationData) {

        Optional<User> user = userRepository.findById(1L);

        Treasure treasure = treasureRepository.save(
                Treasure.builder()
                        .latitude(treasureRegistrationData.getLatitude())
                        .longitude(treasureRegistrationData.getLongitude())
                        .user(user.get())
                        .photoUrl(treasureRegistrationData.getPhotoUrl())
                        .hasQuest(treasureRegistrationData.getHasQuest())
                        .hashTag(treasureRegistrationData.getHashTag())
                        .text(treasureRegistrationData.getText())
                        .build()
        );

        Long questId = null;
        // 퀘스트 포함 여부
        if(treasure.getHasQuest()) {
            Quest quest = questRepository.save(Quest.builder()
                    .treasure(treasure)
                    .question(treasureRegistrationData.getQuestion())
                    .answer0(treasureRegistrationData.getAnswer0())
                    .answer1(treasureRegistrationData.getAnswer1())
                    .answer2(treasureRegistrationData.getAnswer2())
                    .answer3(treasureRegistrationData.getAnswer3())
                    .answerIndex(treasureRegistrationData.getAnswerIndex())
                    .build());
            questId = quest.getId();
        }

        return TreasureCreateRes.builder()
                .treasureId(treasure.getId())
                .questId(questId)
                .build();
    }

    public TreasureDetailRes getTreasure(Long treasureId) {
        Optional<Treasure> treasure = treasureRepository.findById(treasureId);
        Optional<Quest> quest = questRepository.findByTreasure(treasure);

        return TreasureDetailRes.builder()
                .treasureId(treasure.get().getId())
                .questId(quest.get().getId())
                .answer0(quest.get().getAnswer0())
                .answer1(quest.get().getAnswer1())
                .answer2(quest.get().getAnswer2())
                .answer3(quest.get().getAnswer3())
                .answerIndex(quest.get().getAnswerIndex())
                .hashTag(treasure.get().getHashTag())
                .hasQuest(treasure.get().getHasQuest())
                .latitude(treasure.get().getLatitude())
                .longitude(treasure.get().getLongitude())
                .photoUrl(treasure.get().getPhotoUrl())
                .question(quest.get().getQuestion())
                .text(treasure.get().getText())
                .build();
    }

    public List<TreasureListRes> getLists(double latitude, double longitude) {

        List<Treasure> treasures = treasureRepository.getTreasures(longitude, latitude);
        List<TreasureListRes> treasureListRes = new ArrayList<>();

        for (Treasure treasure : treasures) {
            double distance = distance(treasure.getLatitude(), treasure.getLongitude(), latitude, longitude);

            treasureListRes.add(
                    TreasureListRes.builder()
                            .treasureId(treasure.getId())
                            .likeCnt(10)
                            .dislikeCnt(3)
                            .latitude(treasure.getLatitude())
                            .longitude(treasure.getLongitude())
                            .distance(distance)
                            .hashTag(treasure.getHashTag())
                            .build()
            );

        }

        return treasureListRes;
    }

    public void createReaction(ReactionReq reactionReq) {
        User user = userRepository.getById(reactionReq.getUserId());
        Treasure treasure = treasureRepository.getById(reactionReq.getTreasureId());
        // 존재하는 경우
        if(treasureReactionRepository.existsByUserAndTreasureAndReactionType(user, treasure, reactionReq.getReactionType())) {
            throw new CustomException(ErrorCode.USER_ALREADY_REACTION);
        }
        treasureReactionRepository.save(
                TreasureReaction.builder()
                        .treasure(treasure)
                        .user(user)
                        .reactionType(reactionReq.getReactionType())
                        .build()
        );

    }


    private static double distance(double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        dist = dist * 1609.344;

        return (dist);
    }

    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
