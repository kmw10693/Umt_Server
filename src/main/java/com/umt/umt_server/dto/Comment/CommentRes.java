package com.umt.umt_server.dto.Comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ApiModel("댓글 조회 정보")
public class CommentRes
{
    @ApiModelProperty(value = "댓글 식별자", example = "1")
    private Long commentId;

    @ApiModelProperty(value = "유저 식별자", example = "1")
    private Long userId;

    @ApiModelProperty(value = "유저 닉네임", example = "지혜")
    private String nickname;

    @ApiModelProperty(value = "댓글 내용", example = "안녕하세요")
    @NotBlank
    private final String content;

    @ApiModelProperty(value = "댓글 작성 시각", example = "")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "댓글 수정 시각", example = "")
    private LocalDateTime updateAt;

}
