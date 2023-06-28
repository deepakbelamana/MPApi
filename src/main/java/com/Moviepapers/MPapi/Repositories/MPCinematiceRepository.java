package com.Moviepapers.MPapi.Repositories;

import com.Moviepapers.MPapi.models.MPCinematic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MPCinematiceRepository extends MongoRepository<MPCinematic,String> {
    List<MPCinematic> findByMovie(String movie);

    void deleteByMovie(String movie);
}
