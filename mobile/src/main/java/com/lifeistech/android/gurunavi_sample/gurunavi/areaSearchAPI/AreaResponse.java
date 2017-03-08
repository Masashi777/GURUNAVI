package com.lifeistech.android.gurunavi_sample.gurunavi.areaSearchAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/03/08.
 */

public class AreaResponse {

    @SerializedName("@attributes")
    public ApiVersion apiVersion;
    @SerializedName("area")
    public List<Area> areaList;

    public AreaResponse(ApiVersion apiVersion, List<Area> areaList) {
        this.apiVersion = apiVersion;
        this.areaList = areaList;
    }


    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
