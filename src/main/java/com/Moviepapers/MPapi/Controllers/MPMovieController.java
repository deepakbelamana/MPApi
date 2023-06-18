package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPMovieRespository;
import com.Moviepapers.MPapi.models.MPMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MPMovieController {

    @Autowired
    MPMovieRespository MPMovieRespository;

    @GetMapping("/moviesList")
    public List<MPMovie> getAllMovieNamesAsList() {
       return MPMovieRespository.findAll();
    }
}
