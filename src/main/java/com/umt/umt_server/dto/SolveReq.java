package com.umt.umt_server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("퀘스천 답변 보내기 요청 정보")
public class SolveReq {

    @ApiModelProperty(value = "유저 index", example = "1")
    private Long userId;

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "답 index", example = "1")
    private Integer answer;

}
