package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Access implements Serializable {
    public String line;
    public String station;
    @SerializedName("station_exit")
    public String stationExit;
    public String walk;
    public String note;

    public Access(String line, String station, String stationExit, String walk, String note) {

        this.line = line;
        this.station = station;
        this.stationExit = stationExit;
        this.walk = walk;
        this.note = note;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStationExit() {
        return stationExit;
    }

    public void setStationExit(String stationExit) {
        this.stationExit = stationExit;
    }

    public String getWalk() {
        return walk;
    }

    public void setWalk(String walk) {
        this.walk = walk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
