package com.Social.media.model;

import jakarta.persistence.*;


@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialUser" )
    @JoinColumn(name = "Id")
    private SocialProfile socialProfile;
}
