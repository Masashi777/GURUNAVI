package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class PR {
    @SerializedName("pr_short")
    public String prShort;
    @SerializedName("pr_long")
    public String pr_Long;


    public PR(String prShort, String pr_Long) {
        this.prShort = prShort;
        this.pr_Long = pr_Long;
    }


    public String getPrShort() {
        return prShort;
    }

    public void setPrShort(String prShort) {
        this.prShort = prShort;
    }

    public String getPr_Long() {
        return pr_Long;
    }

    public void setPr_Long(String pr_Long) {
        this.pr_Long = pr_Long;
    }

}
