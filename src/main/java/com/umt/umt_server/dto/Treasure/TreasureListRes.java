package com.umt.umt_server.dto.Treasure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("보물 목록 상세 정보")
public class TreasureListRes implements Comparable<TreasureListRes>{

    @ApiModelProperty(value = "보물 index", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "좋아요 개수", example = "1")
    private Long likeCnt;

    @ApiModelProperty(value = "싫어요 개수", example = "1")
    private Long dislikeCnt;

    @ApiModelProperty(value = "위도", example = "32.23")
    private double latitude;

    @ApiModelProperty(value = "경도", example = "38.75")
    private double longitude;

    @ApiModelProperty(value = "거리", example = "2.0")
    private double distance;

    @ApiModelProperty(value = "해시태그", example = "#가나다 #라바사")
    private String hashTag;

    @ApiModelProperty(value = "포인트", example = "50")
    private Integer point;

    @Override
    public int compareTo(TreasureListRes treasureListRes) {
        if (treasureListRes.distance < distance) {
            return 1;
        } else if (treasureListRes.distance > distance) {
            return -1;
        }
        return 0;
    }

}
