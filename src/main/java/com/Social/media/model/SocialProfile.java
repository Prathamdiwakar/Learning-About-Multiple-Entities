package com.Social.media.model;

import jakarta.persistence.*;

@Entity
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @OneToOne
    @JoinColumn(name = "Profile_ID")
    private SocialUser socialUser;
}
