package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Flags {
    @SerializedName("mobile_site")
    public int mobileSite;
    @SerializedName("mobile_coupon")
    public int mobileCoupon;
    @SerializedName("pc_coupon")
    public int pcCoupon;


    public Flags(int mobileSite, int mobileCoupon, int pcCoupon) {
        this.mobileSite = mobileSite;
        this.mobileCoupon = mobileCoupon;
        this.pcCoupon = pcCoupon;
    }


    public int getMobileSite() {
        return mobileSite;
    }

    public void setMobileSite(int mobileSite) {
        this.mobileSite = mobileSite;
    }

    public int getMobileCoupon() {
        return mobileCoupon;
    }

    public void setMobileCoupon(int mobileCoupon) {
        this.mobileCoupon = mobileCoupon;
    }

    public int getPcCoupon() {
        return pcCoupon;
    }

    public void setPcCoupon(int pcCoupon) {
        this.pcCoupon = pcCoupon;
    }
}
