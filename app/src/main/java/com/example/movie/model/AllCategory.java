
package com.example.movie.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCategory {

    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("categoryTitle")
    @Expose
    private String categoryTitle;
    @SerializedName("categoryItemList")
    @Expose
    private List<CategoryItemList> categoryItemList = null;

    /**
     * No args constructor for use in serialization
     */
    public AllCategory() {
    }

    /**
     * @param categoryTitle
     * @param categoryItemList
     * @param categoryId
     */
    public AllCategory(Integer categoryId, String categoryTitle, List<CategoryItemList> categoryItemList) {
        super();
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<CategoryItemList> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItemList> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }
}