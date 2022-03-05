package com.umt.umt_server.domain;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quest extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Treasure treasure;

    private String question;

    private String answer0;

    private String answer1;

    private String answer2;

    private String answer3;

    private Integer answerIndex;

}
