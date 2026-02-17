package com.Social.media.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import static jakarta.persistence.CascadeType.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialUser", cascade = ALL )
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser" ,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private List<UserPost>  userPosts =  new ArrayList<>();

   // Fetch Type:---
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_id"
            , joinColumns = @JoinColumn(name="user_ids")
            , inverseJoinColumns = @JoinColumn(name ="group_id")
    )
    private Set<SocialGroup> socialGroups = new HashSet<>() ;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setSocialProfile(SocialProfile socialProfile) {
        socialProfile.setSocialUser(this);
    }
}
