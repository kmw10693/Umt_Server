package com.umt.umt_server.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("보물 등록 결과 정보")
public class TreasureCreateRes {

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "퀘스트 index", example = "1")
    private Long questId;
}
