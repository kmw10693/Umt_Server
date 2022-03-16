package com.umt.umt_server.dto.Treasure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("보물 등록 요청 정보")
public class TreasureCreateReq {

    @ApiModelProperty(value = "유저 인덱스", required = true, example = "1")
    private Long userId;

    @ApiModelProperty(value = "위도", required = true, example = "image.com")
    @NotNull(message = "위도를 입력해주세요.")
    private double latitude;

    @ApiModelProperty(value = "경도", required = true, example = "image.com")
    @NotNull(message = "경도를 입력해주세요.")
    private double longitude;

    @ApiModelProperty(value = "사진", required = true, example = "image.com")
    @NotBlank(message = "사진을 넣어주세요.")
    private String photoUrl;

    @ApiModelProperty(value = "해시태그", required = true, example = "#가나다 #라바사")
    @NotBlank(message = "해시태그를 입력해주세요.")
    private String hashTag;

    @ApiModelProperty(value = "텍스트", required = true, example = "가나다라마바사")
    @NotBlank(message = "보물의 내용을 입력해주세요.")
    private String text;

    @ApiModelProperty(value = "퀘스트 추가 여부", required = true, example = "true")
    private Boolean hasQuest;

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

    @ApiModelProperty(value = "정답 index", example = "0")
    private Integer answerId;

}
