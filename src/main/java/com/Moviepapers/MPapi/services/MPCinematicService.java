package com.Moviepapers.MPapi.services;

import com.Moviepapers.MPapi.Repositories.MPCinematiceRepository;
import com.Moviepapers.MPapi.models.MPCinematic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPCinematicService {
    @Autowired
    MPCinematiceRepository MPCinematicRepository;

    public List<MPCinematic> getMPCinematicListBasedOnMovie(String movie) {
        return MPCinematicRepository.findByMovie(movie);
    }
}
