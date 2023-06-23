package com.Moviepapers.MPapi.Repositories;

import com.Moviepapers.MPapi.models.MPPaper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MPPaperRepository extends MongoRepository<MPPaper,String> {

    List<MPPaper> findByMovie(String movie);


}
