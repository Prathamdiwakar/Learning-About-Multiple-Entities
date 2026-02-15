package com.Social.media.repositories;

import com.Social.media.model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepositories extends JpaRepository<SocialUser, Long> {
}
