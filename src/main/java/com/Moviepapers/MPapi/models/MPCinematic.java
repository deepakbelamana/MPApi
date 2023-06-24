package com.Moviepapers.MPapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MPCinematic")
public class MPCinematic {

    private String movie;
    private String mpcspath;

    public String getMovie() {
        return movie;
    }

    public MPCinematic() {
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getMpcspath() {
        return mpcspath;
    }

    public void setMpcspath(String mpcspath) {
        this.mpcspath = mpcspath;
    }
}
