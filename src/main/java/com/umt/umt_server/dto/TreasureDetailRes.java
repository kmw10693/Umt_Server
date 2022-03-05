package com.umt.umt_server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("보물 상세 정보")
public class TreasureDetailRes
{
    @ApiModelProperty(value = "퀘스트 index", example = "1")
    private Long questId;

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "해시태그", required = true, example = "#가나다 #라바사")
    private String hashTag;

    @ApiModelProperty(value = "질문", example = "여기는 무엇을 파는 곳 일까요?")
    private String question;

    @ApiModelProperty(value = "선택지 0", example = "선택 1")
    private String answer0;

    @ApiModelProperty(value = "선택지 1", example = "선택 2")
    private String answer1;

    @ApiModelProperty(value = "선택지 2", example = "선택 3")
    private String answer2;

    @ApiModelProperty(value = "선택지 3", example = "선택 4")
    private String answer3;

    @ApiModelProperty(value = "좋아요 개수", example = "1")
    private Long likeCnt;

    @ApiModelProperty(value = "싫어요 개수", example = "1")
    private Long dislikeCnt;
}
