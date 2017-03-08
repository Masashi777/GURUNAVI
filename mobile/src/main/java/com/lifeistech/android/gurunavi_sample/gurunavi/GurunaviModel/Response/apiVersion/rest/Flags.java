package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Flags implements Serializable {
    @SerializedName("mobile_site")
    public String mobileSite;
    @SerializedName("mobile_coupon")
    public String mobileCoupon;
    @SerializedName("pc_coupon")
    public String pcCoupon;


    public Flags(String mobileSite, String mobileCoupon, String pcCoupon) {
        this.mobileSite = mobileSite;
        this.mobileCoupon = mobileCoupon;
        this.pcCoupon = pcCoupon;
    }


    public String getMobileSite() {
        return mobileSite;
    }

    public void setMobileSite(String mobileSite) {
        this.mobileSite = mobileSite;
    }

    public String getMobileCoupon() {
        return mobileCoupon;
    }

    public void setMobileCoupon(String mobileCoupon) {
        this.mobileCoupon = mobileCoupon;
    }

    public String getPcCoupon() {
        return pcCoupon;
    }

    public void setPcCoupon(String pcCoupon) {
        this.pcCoupon = pcCoupon;
    }
}
