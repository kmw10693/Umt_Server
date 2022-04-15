package com.umt.umt_server.domain;

import com.umt.umt_server.dto.Comment.CommentRes;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "treasure_id")
    private Treasure treasure;

    private String content;

    public CommentRes toCommentRes() {
        return CommentRes.builder()
                .commentId(id)
                .userId(user.getId())
                .nickname(user.getNickname())
                .content(content)
                .createAt(getCreateAt())
                .updateAt(getUpdateAt())
                .build();
    }

}
