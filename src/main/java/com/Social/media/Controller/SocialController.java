package com.Social.media.Controller;

import com.Social.media.Service.SocialService;
import com.Social.media.model.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;

    @GetMapping("/social/user/")
    public ResponseEntity<List<SocialUser>> GetSocialUser(){
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);

    }
    @PostMapping("/social/user/")
    public ResponseEntity<SocialUser> CreateSocialUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.CREATED);
    }

}
