package com.umt.umt_server.dto.Comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@ApiModel("댓글 쓰기 요청 정보")
public class CommentCreateReq {

    @ApiModelProperty(value = "유저 idx", example = "1")
    private Long userId;

    @ApiModelProperty(value = "보물 idx", example = "1")
    private Long treasureId;

    @ApiModelProperty(value = "댓글 내용" , example = "감사합니다.")
    private String content;

}
