package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPMovieRespository;
import com.Moviepapers.MPapi.models.MPMovie;
import com.Moviepapers.MPapi.services.MPMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MPMovieController {

    @Autowired
    MPMovieRespository MPMovieRespository;

    @Autowired
    MPMovieService MPMovieService;

    /**
     * fetched all movie names in db
     * @return
     */
    @GetMapping("/moviesList")
    public List<String> getAllMovieNamesAsList() {
        return MPMovieRespository.findAll().stream().map(mpMovie -> mpMovie.getMovie()).toList();
    }

    /**
     * fetches single document based on movie name
     * @param movieName
     * @return
     */
    @GetMapping("/movie/{movieName}")
    public MPMovie getMPMovie(@PathVariable String movieName) {
        return MPMovieService.getMPMovieBasedOnMovie(movieName);
    }
}
