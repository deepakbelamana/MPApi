package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.models.MPCinematic;
import com.Moviepapers.MPapi.services.MPCinematicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MPCinematicController {

    @Autowired
    MPCinematicService MPCinematicService;
    @GetMapping("/mp-cinematic/{movie}")
    public List<MPCinematic> getMPCinematicListBasedOnMovie(@PathVariable String movie){
        return MPCinematicService.getMPCinematicListBasedOnMovie(movie);
    }
}
