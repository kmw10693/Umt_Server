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
@ApiModel("보물 목록 상세 정보")
public class TreasureListRes {

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "좋아요 개수", example = "1")
    private Integer likeCnt;

    @ApiModelProperty(value = "싫어요 개수", example = "1")
    private Integer dislikeCnt;

    @ApiModelProperty(value = "위도", required = true, example = "32.23")
    private double latitude;

    @ApiModelProperty(value = "경도", required = true, example = "38.75")
    private double longitude;

    @ApiModelProperty(value = "거리", required = true, example = "2.0")
    private double distance;

    @ApiModelProperty(value = "해시태그", required = true, example = "#가나다 #라바사")
    private String hashTag;

}
