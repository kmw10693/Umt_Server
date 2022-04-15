package com.umt.umt_server.controllers;

import com.umt.umt_server.application.TreasureService;
import com.umt.umt_server.dto.Quest.QuestRes;
import com.umt.umt_server.dto.Reaction.ReactionReq;
import com.umt.umt_server.dto.Treasure.TreasureCreateReq;
import com.umt.umt_server.dto.Treasure.TreasureCreateRes;
import com.umt.umt_server.dto.Treasure.TreasureRes;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TreasureController {

    private final TreasureService treasureService;

    @PostMapping("/treasure")
    @ApiOperation(value = "보물&퀘스트 등록", notes = "보물과 퀘스트를 등록합니다.")
    @ResponseStatus(HttpStatus.CREATED)
    public TreasureCreateRes createTreasure(@RequestBody TreasureCreateReq treasureCreateReq)
    {
        return treasureService.createTreasure(treasureCreateReq);
    }

    @GetMapping("/quest")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "퀘스트 조회", notes = "퀘스트를 조회합니다.")
    public QuestRes getQuest(@RequestParam @ApiParam(value = "보물 식별자 값")  Long treasureId) {
        return treasureService.getQuest(treasureId);
    }

    @GetMapping("/treasures")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "보물 목록 검색", notes = "보물 목록 상세 정보를 조회합니다. (반경 2KM 내)")
    public TreasureRes getLists(@RequestParam @ApiParam(value = "경도 값") double longitude, @RequestParam @ApiParam(value = "위도 값") double latitude) {
        return treasureService.getLists(latitude, longitude);
    }

    @PostMapping("/treasure/reaction")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "좋아요 or 싫어요 요청", notes = "좋아요와 싫어요를 요청합니다.")
    public void createReaction(@RequestBody ReactionReq reactionReq) {
        treasureService.createReaction(reactionReq);
    }

}
