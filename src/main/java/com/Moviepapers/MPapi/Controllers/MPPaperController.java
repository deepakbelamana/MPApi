package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.models.MPMovie;
import com.Moviepapers.MPapi.models.MPPaper;
import com.Moviepapers.MPapi.services.MPPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MPPaperController {

    @Autowired
    MPPaperService MPPaperService;
    @GetMapping("/mp-paper/{movie}")
    public MPPaper getMPPaperBasedOnMovieName(@PathVariable String movie) {
        return MPPaperService.findMPPaperByMovieName(movie);
    }
}
