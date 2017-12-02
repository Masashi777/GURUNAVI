package com.lifeistech.android.gurunavi_sample.gurunavi.errorAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/12/02.
 */

public class Error {

    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;


    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
