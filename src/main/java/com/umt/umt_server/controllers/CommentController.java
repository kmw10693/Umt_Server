package com.umt.umt_server.controllers;

import com.umt.umt_server.application.CommentService;
import com.umt.umt_server.dto.Comment.CommentCreateReq;
import com.umt.umt_server.dto.Comment.CommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 쓰기 API
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentRes createComment(@RequestBody CommentCreateReq commentCreateReq) {
        return commentService.createComment(commentCreateReq);
    }
}
