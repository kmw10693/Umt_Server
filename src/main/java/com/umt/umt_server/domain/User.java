package com.umt.umt_server.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    @GeneratedValue
    @ApiModelProperty(value = "사용자 인덱스", example = "1")
    private Long id;

    @ApiModelProperty(value = "사용자 이름", required = true, example = "김민우")
    @Builder.Default
    private String name = "";
}
