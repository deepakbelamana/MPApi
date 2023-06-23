package com.Moviepapers.MPapi.services;

import com.Moviepapers.MPapi.Repositories.MPPaperRepository;
import com.Moviepapers.MPapi.models.MPPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPPaperService  {

    @Autowired
    MPPaperRepository MPPaperRepository;

    public MPPaper findMPPaperByMovieName(String movie) {
        return MPPaperRepository.findByMovie(movie);
    }
}