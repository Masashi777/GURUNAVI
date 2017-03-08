package com.lifeistech.android.gurunavi_sample.gurunavi;

import java.io.Serializable;

/**
 * Created by Masashi Hamaguchi on 2017/02/21.
 */

public abstract class GurunaviConnect implements Serializable {

    public static final String AREASEARCH_DOMAIN = "https://api.gnavi.co.jp/master/AreaSearchAPI/20150630";
    public static final String PREFSEARCH_DOMAIN = "https://api.gnavi.co.jp/master/PrefSearchAPI/20150630";
    public static final String AREAL_DOMAIN = "https://api.gnavi.co.jp/master/GAreaLargeSearchAPI/20150630";

    public static final String REQUEST_DOMAIN = "https://api.gnavi.co.jp/RestSearchAPI/20150630";


    public interface GurunaviSearchListener {

        public void onSuccess(String result);

        public void onFailed(String error);

    }


    public abstract void areaSearch(final String keyId, final String format, final String lang, final GurunaviSearchListener listener);

    public abstract void prefSearch(final String keyId, final String format, final String lang, final GurunaviSearchListener listener);

    public abstract void GareaLSearch(final String keyId, final String format, final String lang, final GurunaviSearchListener listener);

    public abstract void search(final String keyId, final String format, final String freeWord, final GurunaviSearchListener listener);


}
