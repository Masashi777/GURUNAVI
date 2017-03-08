package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Code {
    public String areacode;
    public String areaname;
    public String prefcode;
    public String prefname;
    @SerializedName("areacode_s")
    public String areacodeS;
    @SerializedName("areaname_s")
    public String areanameS;

    public List<Object> category_code_l;
    public List<Object> category_name_l;
    public List<Object> category_code_s;
    public List<Object> category_name_s;


    public Code(List<Object> category_name_s, String areacode, String areaname, String prefcode, String prefname, String areacodeS, String areanameS, List<Object> category_code_l, List<Object> category_name_l, List<Object> category_code_s) {
        this.category_name_s = category_name_s;
        this.areacode = areacode;
        this.areaname = areaname;
        this.prefcode = prefcode;
        this.prefname = prefname;
        this.areacodeS = areacodeS;
        this.areanameS = areanameS;
        this.category_code_l = category_code_l;
        this.category_name_l = category_name_l;
        this.category_code_s = category_code_s;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getPrefcode() {
        return prefcode;
    }

    public void setPrefcode(String prefcode) {
        this.prefcode = prefcode;
    }

    public String getPrefname() {
        return prefname;
    }

    public void setPrefname(String prefname) {
        this.prefname = prefname;
    }

    public String getAreacodeS() {
        return areacodeS;
    }

    public void setAreacodeS(String areacodeS) {
        this.areacodeS = areacodeS;
    }

    public String getAreanameS() {
        return areanameS;
    }

    public void setAreanameS(String areanameS) {
        this.areanameS = areanameS;
    }

    public List<Object> getCategory_code_l() {
        return category_code_l;
    }

    public void setCategory_code_l(List<Object> category_code_l) {
        this.category_code_l = category_code_l;
    }

    public List<Object> getCategory_name_l() {
        return category_name_l;
    }

    public void setCategory_name_l(List<Object> category_name_l) {
        this.category_name_l = category_name_l;
    }

    public List<Object> getCategory_code_s() {
        return category_code_s;
    }

    public void setCategory_code_s(List<Object> category_code_s) {
        this.category_code_s = category_code_s;
    }

    public List<Object> getCategory_name_s() {
        return category_name_s;
    }

    public void setCategory_name_s(List<Object> category_name_s) {
        this.category_name_s = category_name_s;
    }
}
