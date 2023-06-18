package com.Moviepapers.MPapi.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MPMovie")
public class MPMovie {

    private String Movie;
    private boolean MPPAPExist;
    private boolean MPCExist;
    private boolean MPRVExist;

    public String getMovie() {
        return Movie;
    }

    public void setMovie(String movie) {
        Movie = movie;
    }

    public boolean isMPPAPExist() {
        return MPPAPExist;
    }

    public void setMPPAPExist(boolean MPPAPExist) {
        this.MPPAPExist = MPPAPExist;
    }

    public boolean isMPCExist() {
        return MPCExist;
    }

    public void setMPCExist(boolean MPCExist) {
        this.MPCExist = MPCExist;
    }

    public boolean isMPRVExist() {
        return MPRVExist;
    }

    public void setMPRVExist(boolean MPRVExist) {
        this.MPRVExist = MPRVExist;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Movie='" + Movie + '\'' +
                ", MPPAPExist=" + MPPAPExist +
                ", MPCExist=" + MPCExist +
                ", MPRVExist=" + MPRVExist +
                '}';
    }
}
