package com.Social.media.repositories;

import com.Social.media.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepositories extends JpaRepository<UserPost, Long> {
}
