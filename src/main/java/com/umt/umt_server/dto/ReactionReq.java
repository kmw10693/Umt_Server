package com.umt.umt_server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("좋아요/싫어요 요청 정보")
public class ReactionReq {

    @ApiModelProperty(value = "유저 index", required = true, example = "1")
    private Long userId;

    @ApiModelProperty(value = "보물 index", required = true, example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "좋아요, 싫어요 구분 여부", required = true, example = "like or hate")
    private String reactionType;
}
