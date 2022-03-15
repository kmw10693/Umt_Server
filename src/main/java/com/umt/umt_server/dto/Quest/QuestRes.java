package com.umt.umt_server.dto.Quest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("보물 상세 정보")
public class QuestRes
{
    @ApiModelProperty(value = "퀘스트 인덱스", example = "1")
    private Long questId;

    @ApiModelProperty(value = "보물 인덱스" , example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "해시태그", example = "#가나다 #라바사")
    private String hashTag;

    @ApiModelProperty(value = "포인트", example = "50")
    private Integer point;

    @ApiModelProperty(value = "좋아요 개수", example = "1")
    private Long likeCnt;

    @ApiModelProperty(value = "싫어요 개수", example = "1")
    private Long dislikeCnt;

    @ApiModelProperty(value = "질문", example = "내가 이 장소에서 고백했을 때의 멘트는?")
   private String question;

    @ApiModelProperty(value = "선택지 0", example = "이거 다 마시면 나랑 사귀는거다.")
    private String answer0;

    @ApiModelProperty(value = "선택지 1", example = "내일은 연인으로 만날까요.")
    private String answer1;

    @ApiModelProperty(value = "선택지 2", example = "이게 정답인 고백 멘트.")
    private String answer2;

    @ApiModelProperty(value = "선택지 3", example = "내게 남은 사랑을 드릴게요.")
    private String answer3;

}
