package com.Social.media.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialUser" )
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser")
    private List<UserPost>  userPosts;

    @ManyToMany
    @JoinTable(
            name = "user_id"
            , joinColumns = @JoinColumn(name="user_ids")
            , inverseJoinColumns = @JoinColumn(name ="group_id")
    )
    private Set<SocialGroup> socialGroups;
}
