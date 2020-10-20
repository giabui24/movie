package com.example.movie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryItemList {

    @SerializedName("fileUrl")
    @Expose
    private String fileUrl;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("movieName")
    @Expose
    private String movieName;

    /**
     * No args constructor for use in serialization
     *
     */
    public CategoryItemList() {
    }

    /**
     *
     * @param imageUrl
     * @param fileUrl
     * @param id
     * @param movieName
     */
    public CategoryItemList(String fileUrl, Integer id, String imageUrl, String movieName) {
        super();
        this.fileUrl = fileUrl;
        this.id = id;
        this.imageUrl = imageUrl;
        this.movieName = movieName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}
