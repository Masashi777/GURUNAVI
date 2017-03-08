package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel;

import com.google.gson.annotations.SerializedName;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.ApiVersion;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;


import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class GurunaviResponse {


    @SerializedName("@attributes")
    public ApiVersion attributes;
    @SerializedName("total_hit_count")
    public String totalHitCount;
    @SerializedName("hit_per_page")
    public String hitPerPage;
    @SerializedName("page_offset")
    public String pageOffset;
    @SerializedName("rest")
    public List<Rest> restList;


    public GurunaviResponse(ApiVersion attributes, String totalHitCount, String hitPerPage, String pageOffset, List<Rest> restList) {
        this.attributes = attributes;
        this.totalHitCount = totalHitCount;
        this.hitPerPage = hitPerPage;
        this.pageOffset = pageOffset;
        this.restList = restList;
    }


    public ApiVersion getAttributes() {
        return attributes;
    }

    public void setAttributes(ApiVersion attributes) {
        this.attributes = attributes;
    }

    public String getTotalHitCount() {
        return totalHitCount;
    }

    public void setTotalHitCount(String totalHitCount) {
        this.totalHitCount = totalHitCount;
    }

    public String getHitPerPage() {
        return hitPerPage;
    }

    public void setHitPerPage(String hitPerPage) {
        this.hitPerPage = hitPerPage;
    }

    public String getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(String pageOffset) {
        this.pageOffset = pageOffset;
    }

    public List<Rest> getRestList() {
        return restList;
    }

    public void setRestList(List<Rest> restList) {
        this.restList = restList;
    }


}
