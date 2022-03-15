package com.umt.umt_server.dto.Solve;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("정답 시 보물 반환 정보")
public class SolveRes {

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "유저 index", example = "1")
    private Long userId;

    @ApiModelProperty(value = "유저 닉네임", example = "닉스")
    private String nickname;

    @ApiModelProperty(value = "유저 프로필 사진", example = "image.com")
    private String imageUrl;

    @ApiModelProperty(notes = "생성 시각", example = "2022-01-26T22:07:17.0831141")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "보물 사진", example = "image.com")
    private String photoUrl;

    @ApiModelProperty(value = "보물 해시태그", example = "#인생사진 #포토스팟 #퀘스트존잼")
    private String hashTag;

    @ApiModelProperty(value = "보물 설명", example = "널 좋아해. 널 사랑해.")
    private String text;

    @ApiModelProperty(value = "좋아요 수", example = "15")
    private Long likeCnt;

    @ApiModelProperty(value = "싫어요 수", example = "3")
    private Long dislikeCnt;

}
