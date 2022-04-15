package com.umt.umt_server.dto.Jwt;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRes {
    private String grantType;

    private String accessToken;

    private String refreshToken;

    private Long accessTokenExpireDate;

    private Long refreshTokenExpireDate;

}
