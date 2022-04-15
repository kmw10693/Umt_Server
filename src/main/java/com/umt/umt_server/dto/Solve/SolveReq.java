package com.umt.umt_server.dto.Solve;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("퀘스천 답변 보내기 요청 정보")
public class SolveReq {

    @ApiModelProperty(value = "유저 인덱스", example = "1")
    private Long userId;

    @ApiModelProperty(value = "보물 인덱스", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "정답 선택지(0~3)", example = "1")
    private Integer answer;

}
