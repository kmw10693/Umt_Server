package com.umt.umt_server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("퀘스천 답변 반환 정보")
public class SolveRes {

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "보물 사진", example = "image.com")
    private String photoUrl;

    @ApiModelProperty(value = "보물 해시태그", example = "#성공적, #성공")
    private String hashTag;

    @ApiModelProperty(value = "좋아요 수", example = "15")
    private Integer likeCnt;

    @ApiModelProperty(value = "싫어요 수", example = "3")
    private Integer dislikeCnt;

    @ApiModelProperty(value = "보물 설명", example = "소중한 보물")
    private String text;

}
