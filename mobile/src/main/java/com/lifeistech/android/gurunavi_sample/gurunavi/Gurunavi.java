package com.lifeistech.android.gurunavi_sample.gurunavi;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Gurunavi {

    public Gurunavi() {

    }


    public void areaSearch(GurunaviConnect connect, String keyId, String format, String lang, final GurunaviConnect.GurunaviSearchListener listener) {
        connect.areaSearch(keyId, format, lang, listener);
    }

    public void prefSearch(GurunaviConnect connect, String keyId, String format, String lang, final GurunaviConnect.GurunaviSearchListener listener) {
        connect.prefSearch(keyId, format, lang, listener);
    }

    public void GareaLSearch(GurunaviConnect connect, String keyId, String format, String lang, final GurunaviConnect.GurunaviSearchListener listener) {
        connect.GareaLSearch(keyId, format, lang, listener);
    }


    public void search(GurunaviConnect connect, String freeWord, Integer page, final GurunaviConnect.GurunaviSearchListener listener) {
        connect.search(freeWord, page, listener);
    }


}
