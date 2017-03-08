package com.lifeistech.android.gurunavi_sample.gurunavi.GareaLSearchAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/03/09.
 */

public class ApiVersion {
    @SerializedName("@api_version")
    public String apiVersion;


    public ApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }


    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
