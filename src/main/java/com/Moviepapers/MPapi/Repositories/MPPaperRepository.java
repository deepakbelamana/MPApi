package com.Moviepapers.MPapi.Repositories;

import com.Moviepapers.MPapi.models.MPPaper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MPPaperRepository extends MongoRepository<MPPaper,String> {

    MPPaper findByMovie(String movie);


}
