package com.umt.umt_server.application;

import com.umt.umt_server.domain.User;
import com.umt.umt_server.dto.User.UserResultData;
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
public class UserService {

    private final UserRepository userRepository;
    private final SolveRepository solveRepository;
    private final TreasureRepository treasureRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public UserResultData getMyPage(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        Long shareCnt = treasureRepository.findCountByUser(user.get());
        Long treasureCnt = solveRepository.CountByUser(user.get());

        return UserResultData.builder()
                .nickname(user.get().getNickname())
                .imageUrl(user.get().getImageUrl())
                // TODO 레벨 추가
                .level(5)
                .nickname(user.get().getNickname())
                .treasureShare(shareCnt)
                .treasureSeen(treasureCnt)
                .build();
    }

}
