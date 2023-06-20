package com.Moviepapers.MPapi.Repositories;

import com.Moviepapers.MPapi.models.MPMovie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MPMovieRespository extends MongoRepository <MPMovie,String> {
        MPMovie findByMovie(String movie);
}
