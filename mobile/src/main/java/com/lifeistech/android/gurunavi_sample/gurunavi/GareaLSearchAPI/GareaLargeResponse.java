package com.lifeistech.android.gurunavi_sample.gurunavi.GareaLSearchAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/03/09.
 */

public class GareaLargeResponse {
    @SerializedName("@attributes")
    public ApiVersion apiVersion;

    @SerializedName("garea_large")
    public List<GareaLarge> gareaLargeList;


    public GareaLargeResponse(ApiVersion apiVersion, List<GareaLarge> gareaLargeList) {
        this.apiVersion = apiVersion;
        this.gareaLargeList = gareaLargeList;
    }


    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<GareaLarge> getGareaLargeList() {
        return gareaLargeList;
    }

    public void setGareaLargeList(List<GareaLarge> gareaLargeList) {
        this.gareaLargeList = gareaLargeList;
    }
}
