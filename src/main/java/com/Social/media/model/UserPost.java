package com.Social.media.model;

import jakarta.persistence.*;

@Entity
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private SocialUser socialUser;
}
