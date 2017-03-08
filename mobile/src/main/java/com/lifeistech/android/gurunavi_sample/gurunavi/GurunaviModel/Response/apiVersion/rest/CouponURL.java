package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class CouponURL {
    public String pc;
    public String mobile;

    public CouponURL(String pc, String mobile) {

        this.pc = pc;
        this.mobile = mobile;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
