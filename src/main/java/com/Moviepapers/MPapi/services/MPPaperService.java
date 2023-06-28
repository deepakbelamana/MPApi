package com.Moviepapers.MPapi.services;

import com.Moviepapers.MPapi.Repositories.MPPaperRepository;
import com.Moviepapers.MPapi.models.MPPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPPaperService  {

    @Autowired
    MPPaperRepository MPPaperRepository;

    public List<MPPaper> findMPPaperByMovieName(String movie) {
        return MPPaperRepository.findByMovie(movie);
    }

    public String deleteMPPaperBasedOnMovie(String movie)
    {
        try{
            MPPaperRepository.deleteByMovie(movie);
            return"Success";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }
}
