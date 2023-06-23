package com.Moviepapers.MPapi.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MPPapers")
public class MPPaper {

    private String mppath;
    private String movie;

    @Override
    public String toString() {
        return "MPPapers{" +
                "mppath='" + mppath + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }

    public String getMppath() {
        return mppath;
    }

    public void setMppath(String mppath) {
        this.mppath = mppath;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
