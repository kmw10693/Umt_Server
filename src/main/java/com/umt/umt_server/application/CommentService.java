package com.umt.umt_server.application;

import com.umt.umt_server.domain.Comment;
import com.umt.umt_server.domain.Treasure;
import com.umt.umt_server.domain.User;
import com.umt.umt_server.dto.Comment.CommentCreateReq;
import com.umt.umt_server.dto.Comment.CommentRes;
import com.umt.umt_server.infra.CommentRepository;
import com.umt.umt_server.infra.TreasureRepository;
import com.umt.umt_server.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TreasureRepository treasureRepository;
    private final UserRepository userRepository;

    /**
     * 댓글 쓰기
     * @param commentCreateReq
     * @return
     */
    public CommentRes createComment(CommentCreateReq commentCreateReq) {
        Optional<Treasure> treasure = treasureRepository.findById(commentCreateReq.getTreasureId());
        Optional<User> user = userRepository.findById(commentCreateReq.getUserId());

        return commentRepository.save(
                Comment.builder()
                        .user(user.get())
                        .treasure(treasure.get())
                        .content(commentCreateReq.getContent())
                        .build()
        ).toCommentRes();
    }
}
