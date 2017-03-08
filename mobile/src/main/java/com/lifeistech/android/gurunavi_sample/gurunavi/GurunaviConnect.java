package com.lifeistech.android.gurunavi_sample.gurunavi;

import java.io.Serializable;

/**
 * Created by Masashi Hamaguchi on 2017/02/21.
 */

public abstract class GurunaviConnect implements Serializable {

    public static final String REQUEST_DOMAIN = "https://api.gnavi.co.jp/RestSearchAPI/20150630";


    public interface GurunaviSearchListener {

        public void onSuccess(String result);

        public void onFailed(String error);

    }

    public abstract void search(final String keyId, final String format, final String freeWord, final GurunaviSearchListener listener);


}
