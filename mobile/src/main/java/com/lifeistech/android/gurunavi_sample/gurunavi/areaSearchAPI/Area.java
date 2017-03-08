package com.lifeistech.android.gurunavi_sample.gurunavi.areaSearchAPI;

/**
 * Created by Masashi Hamaguchi on 2017/03/08.
 */

public class Area {

    public String area_code;
    public String area_name;


    public Area(String area_code, String area_name) {
        this.area_code = area_code;
        this.area_name = area_name;
    }


    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
}
