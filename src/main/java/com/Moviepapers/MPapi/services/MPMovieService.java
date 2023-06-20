package com.Moviepapers.MPapi.services;

import com.Moviepapers.MPapi.Repositories.MPMovieRespository;
import com.Moviepapers.MPapi.models.MPMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPMovieService {

    @Autowired
    MPMovieRespository mpMovieRespository;

    public MPMovie getMPMovieBasedOnMovie(String movie){
        return mpMovieRespository.findByMovie(movie);
    }
}
