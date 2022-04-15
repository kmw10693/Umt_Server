package com.umt.umt_server.application;

import com.umt.umt_server.config.security.JwtProvider;
import com.umt.umt_server.domain.User;
import com.umt.umt_server.dto.Jwt.TokenRes;
import com.umt.umt_server.dto.Session.LoginReq;
import com.umt.umt_server.dto.Session.LoginRes;
import com.umt.umt_server.dto.Session.SignupReq;
import com.umt.umt_server.dto.Session.SignupRes;
import com.umt.umt_server.errors.CustomException;
import com.umt.umt_server.errors.ErrorCode;
import com.umt.umt_server.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SessionService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final RedisTemplate redisTemplate;

    @Transactional
    // 회원 가입
    public SignupRes signup(SignupReq signupReq) {
        if(userRepository.existsByEmail(signupReq.getEmail())) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        User user = userRepository.save(User.builder()
                .email(signupReq.getEmail())
                .password(passwordEncoder.encode(signupReq.getPassword()))
                .nickname(signupReq.getNickname())
                .build());

        return SignupRes.toSignupRes(user);
    }

    public TokenRes login(LoginReq loginReq) {
        User user = userRepository.findByEmail(loginReq.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        if(!passwordEncoder.matches(loginReq.getPassword(), user.getPassword()))
            throw new CustomException(ErrorCode.PASSWORD_NOT_MATCHED);

        TokenRes tokenRes = jwtProvider.createTokenData(user.getId());

        redisTemplate.opsForValue()
                .set("RT:" + user.getEmail(), tokenRes.getRefreshToken(), tokenRes.getRefreshTokenExpireDate(), TimeUnit.MILLISECONDS);

        return tokenRes;

    }

}
