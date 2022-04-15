package com.umt.umt_server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.*;

/**
 * User 도메인
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ApiModel("사용자 정보")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "사용자 idx", example = "1")
    private Long id;

    @ApiModelProperty(value = "사용자 이메일", example = "kmw106933@naver.com")
    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @ApiModelProperty(value = "사용자 패스워드", example = "abc123")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(length = 100)
    private String password;

    @ApiModelProperty(value = "사용자 닉네임", example = "닉스")
    private String nickname;

    @ApiModelProperty(value = "프로필 사진", example = "image.com")
    private String imageUrl;

}
