package com.umt.umt_server.controllers;

import com.umt.umt_server.application.SolveService;
import com.umt.umt_server.dto.SolveReq;
import com.umt.umt_server.dto.SolveRes;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SolveController {

    private final SolveService solveService;

    @PostMapping("/solve")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "퀘스트 답변 보내기(Solve 등록)", notes = "사용자에게 답을 받아 퀘스트의 답과 일치하는지 확인합니다.")
    public SolveRes createSolve(@RequestBody SolveReq solveReq) {
        return solveService.createSolve(solveReq);
    }

}
