package com.Social.media.repositories;

import com.Social.media.model.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepositories extends JpaRepository<SocialProfile, Long> {
}
