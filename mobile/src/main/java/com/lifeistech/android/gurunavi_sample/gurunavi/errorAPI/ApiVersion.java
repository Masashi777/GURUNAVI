package com.lifeistech.android.gurunavi_sample.gurunavi.errorAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/12/02.
 */

public class ApiVersion {

    @SerializedName("api_version")
    public String apiversion;

    public ApiVersion(String apiversion) {
        this.apiversion = apiversion;
    }


    public String getApiversion() {
        return apiversion;
    }

    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }
}
