package com.lifeistech.android.gurunavi_sample.gurunavi.GareaLSearchAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/03/09.
 */

public class GareaLarge {
    @SerializedName("areacode_l")
    public String areacodeL;

    @SerializedName("areaname_l")
    public String areanameL;

    public List<Pref> prefList;


    public GareaLarge(String areacodeL, String areanameL, List<Pref> prefList) {
        this.areacodeL = areacodeL;
        this.areanameL = areanameL;
        this.prefList = prefList;
    }


    public String getAreacodeL() {
        return areacodeL;
    }

    public void setAreacodeL(String areacodeL) {
        this.areacodeL = areacodeL;
    }

    public String getAreanameL() {
        return areanameL;
    }

    public void setAreanameL(String areanameL) {
        this.areanameL = areanameL;
    }

    public List<Pref> getPrefList() {
        return prefList;
    }

    public void setPrefList(List<Pref> prefList) {
        this.prefList = prefList;
    }
}
