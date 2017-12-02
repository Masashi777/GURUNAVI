package com.lifeistech.android.gurunavi_sample.gurunavi.errorAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/12/02.
 */

public class ErrorResponse {

    @SerializedName("@attributes")
    public ApiVersion apiVersion;

    @SerializedName("error")
    public Error error;

    public ErrorResponse(ApiVersion apiVersion, Error error) {
        this.apiVersion = apiVersion;
        this.error = error;
    }

    public ApiVersion getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
