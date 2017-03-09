package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion;

import java.io.Serializable;

/**
 * Created by hashizumeakitoshi on 2017/03/01.
 */

public class Order implements Serializable {

    public String order;

    public Order(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
