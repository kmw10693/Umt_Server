package com.umt.umt_server.dto.Session;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupReq {
    private String email;
    private String password;
    private String nickname;

}
