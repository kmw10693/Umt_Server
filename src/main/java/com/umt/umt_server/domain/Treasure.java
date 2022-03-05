package com.umt.umt_server.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treasure extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;

    private double longitude;

    @ManyToOne(fetch = LAZY)
    private User user;

    private String photoUrl;

    private String text;

    private String hashTag;

    private Boolean hasQuest;

}
