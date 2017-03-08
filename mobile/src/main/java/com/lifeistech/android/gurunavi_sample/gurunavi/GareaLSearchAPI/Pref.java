package com.lifeistech.android.gurunavi_sample.gurunavi.GareaLSearchAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Masashi Hamaguchi on 2017/03/09.
 */

public class Pref {
    @SerializedName("pref_code")
    public String prefCode;

    @SerializedName("pref_name")
    public String prefName;


    public Pref(String prefCode, String prefName) {
        this.prefCode = prefCode;
        this.prefName = prefName;
    }


    public String getPrefCode() {
        return prefCode;
    }

    public void setPrefCode(String prefCode) {
        this.prefCode = prefCode;
    }

    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }
}
