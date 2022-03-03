package com.umt.umt_server.application;

import com.umt.umt_server.domain.User;
import com.umt.umt_server.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 사용자의 요청을 받아, 실제 내부에서 작동하는 클래스 입니다.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
