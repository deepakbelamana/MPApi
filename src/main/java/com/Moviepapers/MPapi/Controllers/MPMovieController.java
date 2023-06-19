package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPMovieRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MPMovieController {

    @Autowired
    MPMovieRespository MPMovieRespository;

    @GetMapping("/moviesList")
    public List<String> getAllMovieNamesAsList() {
       return MPMovieRespository.findAll().stream().map(mpMovie -> mpMovie.getMovie()).toList();
    }
}
