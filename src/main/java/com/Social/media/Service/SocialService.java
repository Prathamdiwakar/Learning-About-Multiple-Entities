package com.Social.media.Service;

import com.Social.media.model.SocialUser;
import com.Social.media.repositories.SocialUserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    SocialUserRepositories socialUserRepositories;

    public List<SocialUser> getAllUsers(){
        return socialUserRepositories.findAll();
    }
    
    public SocialUser saveUser(SocialUser socialUser){
        return socialUserRepositories.save(socialUser);
    }
}
