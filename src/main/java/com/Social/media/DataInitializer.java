package com.Social.media;

import com.Social.media.model.SocialGroup;
import com.Social.media.model.SocialProfile;
import com.Social.media.model.SocialUser;
import com.Social.media.model.UserPost;
import com.Social.media.repositories.SocialGroupRepositories;
import com.Social.media.repositories.SocialProfileRepositories;
import com.Social.media.repositories.SocialUserRepositories;
import com.Social.media.repositories.UserPostRepositories;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DataInitializer {

    private  final SocialUserRepositories socialUserRepositories;
    private final SocialGroupRepositories  socialGroupRepositories;
    private  final UserPostRepositories userPostRepositories;
    private final SocialProfileRepositories socialProfileRepositories;

    public DataInitializer(SocialUserRepositories socialUserRepositories, SocialGroupRepositories socialGroupRepositories, UserPostRepositories userPostRepositories, SocialProfileRepositories socialProfileRepositories) {
        this.socialUserRepositories = socialUserRepositories;
        this.socialGroupRepositories = socialGroupRepositories;
        this.userPostRepositories = userPostRepositories;
        this.socialProfileRepositories = socialProfileRepositories;
    }

    @Bean
   public CommandLineRunner initializeData(){
       return args -> {
           // Creating Some User
           SocialUser User = new SocialUser();
           SocialUser User2 = new SocialUser();
           SocialUser User3 = new SocialUser();

           // Saving the User
           socialUserRepositories.save(User);
           socialUserRepositories.save(User2);
           socialUserRepositories.save(User3);

           //Creating User Group
           SocialGroup socialGroup = new SocialGroup();
           SocialGroup socialGroup2 = new SocialGroup();

           //Add User to the Group
           socialGroup.getSocialUsers().add(User);
           socialGroup.getSocialUsers().add(User2);

           socialGroup2.getSocialUsers().add(User);
           socialGroup2.getSocialUsers().add(User2);

           // Save these Group on Database
           socialGroupRepositories.save(socialGroup);
           socialGroupRepositories.save(socialGroup2);

           // Associate User With Groups
           User.getSocialGroups().add(socialGroup);
           User.getSocialGroups().add(socialGroup2);
           User2.getSocialGroups().add(socialGroup);
           User3.getSocialGroups().add(socialGroup2);

           //Save User Back to DataBase TO Update Association
           socialUserRepositories.save(User);
           socialUserRepositories.save(User2);
           socialUserRepositories.save(User3);

           //Create Some new Post
           UserPost post1 = new UserPost();
           UserPost post2 = new UserPost();
           UserPost post3 = new UserPost();

           //Associate Post With User
           post1.setSocialUser(User);
           post2.setSocialUser(User2);
           post3.setSocialUser(User3);

           // Save posts to the database (assuming you have a PostRepository)
           userPostRepositories.save(post1);
           userPostRepositories.save(post2);
           userPostRepositories.save(post3);

           //create some new profile
           SocialProfile profile1 = new SocialProfile();
           SocialProfile profile2 = new SocialProfile();
           SocialProfile profile3 = new SocialProfile();

           //Associate Profile With User
           profile1.setSocialUser(User);
           profile2.setSocialUser(User2);
           profile3.setSocialUser(User3);

           // Save profiles to the database (assuming you have a SocialProfileRepository)
           socialProfileRepositories.save(profile1);
           socialProfileRepositories.save(profile2);
           socialProfileRepositories.save(profile3);
       };
   }

}
