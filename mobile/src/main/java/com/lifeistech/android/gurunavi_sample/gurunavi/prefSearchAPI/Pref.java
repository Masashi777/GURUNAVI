package com.lifeistech.android.gurunavi_sample.gurunavi.prefSearchAPI;

/**
 * Created by Masashi Hamaguchi on 2017/03/08.
 */

public class Pref {

    public String pref_code;
    public String pref_name;
    public String area_code;


    public Pref(String pref_code, String pref_name, String area_code) {
        this.pref_code = pref_code;
        this.pref_name = pref_name;
        this.area_code = area_code;
    }


    public String getPref_code() {
        return pref_code;
    }

    public void setPref_code(String pref_code) {
        this.pref_code = pref_code;
    }

    public String getPref_name() {
        return pref_name;
    }

    public void setPref_name(String pref_name) {
        this.pref_name = pref_name;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }
}
