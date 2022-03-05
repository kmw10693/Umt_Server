package com.umt.umt_server.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@ApiModel("보물 목록 상세 정보")
public class TreasureRes {

    @Builder.Default
    private List<TreasureListRes> treasureLists = new ArrayList<>();

    public TreasureRes(List<TreasureListRes> treasureListRes) {
        treasureLists = treasureListRes;
    }
}
