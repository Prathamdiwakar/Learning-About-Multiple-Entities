package com.Social.media.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "socialGroups")
    private Set<SocialUser> socialUsers;
}
