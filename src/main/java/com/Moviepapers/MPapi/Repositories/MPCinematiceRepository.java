package com.Moviepapers.MPapi.Repositories;

import com.Moviepapers.MPapi.models.MPCinematic;
import com.Moviepapers.MPapi.models.MPPaper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MPCinematiceRepository extends MongoRepository<MPCinematic,String> {
    List<MPCinematic> findByMovie(String movie);
}
