package com.lifeistech.android.gurunavi_sample.gurunavi.prefSearchAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/03/08.
 */

public class PrefResponse {

    @SerializedName("@attributes")
    public ApiVersion apiVersion;

    @SerializedName("pref")
    public List<Pref> prefList;

    public PrefResponse(ApiVersion apiVersion, List<Pref> prefList) {
        this.apiVersion = apiVersion;
        this.prefList = prefList;
    }


    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<Pref> getPrefList() {
        return prefList;
    }

    public void setPrefList(List<Pref> prefList) {
        this.prefList = prefList;
    }
}
