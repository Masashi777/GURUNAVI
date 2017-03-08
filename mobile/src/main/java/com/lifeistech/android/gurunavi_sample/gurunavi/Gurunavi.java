package com.lifeistech.android.gurunavi_sample.gurunavi;

/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Gurunavi {

    public Gurunavi() {

    }

    public void search(GurunaviConnect connect, String keyId, String format, String freeWord, final GurunaviConnect.GurunaviSearchListener listener) {
        connect.search(keyId, format, freeWord, listener);
    }


}
