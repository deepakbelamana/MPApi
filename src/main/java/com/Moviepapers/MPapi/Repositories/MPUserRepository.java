package com.Moviepapers.MPapi.Repositories;

import com.Moviepapers.MPapi.models.MPUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface MPUserRepository extends MongoRepository<MPUser,String> {

    @Query("{'email' : ?0}")
    @Update("{'$set': {'liked': ?1}}")
    void updateUserLikedImgInfo(String email,String[] likedImg);

    MPUser findByEmail(String email);
}
