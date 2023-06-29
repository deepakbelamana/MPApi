package com.Moviepapers.MPapi.models;

public class MPBulkUploadMongo {

    private String movie;
    private String productFolderOption;

    private String filename;
    private int imageStartNumber;

    private int imageEndNumber;

    private String imgExtension;

    public String getImgExtension() {
        return imgExtension;
    }

    public void setImgExtension(String imgExtension) {
        this.imgExtension = imgExtension;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getProductFolderOption() {
        return productFolderOption;
    }

    public void setProductFolderOption(String productFolderOption) {
        this.productFolderOption = productFolderOption;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getImageStartNumber() {
        return imageStartNumber;
    }

    public void setImageStartNumber(int imageStartNumber) {
        this.imageStartNumber = imageStartNumber;
    }

    public int getImageEndNumber() {
        return imageEndNumber;
    }

    public void setImageEndNumber(int imageEndNumber) {
        this.imageEndNumber = imageEndNumber;
    }
}
