package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class ImageURL implements Serializable {
    @SerializedName("shop_image1")
    public String shopImage1;
    @SerializedName("shop_image2")
    public String shopImage2;
    public String qrcode;

    public ImageURL(String shopImage1, String shopImage2, String qrcode) {
        this.shopImage1 = shopImage1;
        this.shopImage2 = shopImage2;
        this.qrcode = qrcode;
    }

    public String getShopImage1() {
        return shopImage1;
    }

    public void setShopImage1(String shopImage1) {
        this.shopImage1 = shopImage1;
    }

    public String getShopImage2() {
        return shopImage2;
    }

    public void setShopImage2(String shopImage2) {
        this.shopImage2 = shopImage2;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
