package com.lifeistech.android.gurunavi_sample.gurunavi;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by Masashi Hamaguchi on 2017/02/21.
 */


public class GurunaviRetrofit extends GurunaviConnect {

    public interface GurunaviApiService {

        @GET("/")
        public void areaSearch(@Query("keyid") String keyId,
                               @Query("format") String format,
                               @Query("lang") String lang,
                               Callback<Response> callback);

        @GET("/")
        public void prefSearch(@Query("keyid") String keyId,
                               @Query("format") String format,
                               @Query("lang") String lang,
                               Callback<Response> callback);

        @GET("/")
        public void GareaLSearch(@Query("keyid") String keyId,
                               @Query("format") String format,
                               @Query("lang") String lang,
                               Callback<Response> callback);


        @GET("/")
        public void search(@Query("keyid") String keyId,
                           @Query("format") String format,
                           @Query("freeword") String freeWord,
                           Callback<Response> callback);

    }


    //エリアマスタ
    public void areaSearch(final String keyId, final  String format, final String lang, final GurunaviSearchListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(AREASEARCH_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        GurunaviApiService service = restAdapter.create(GurunaviApiService.class);

        service.areaSearch(keyId, format, lang, new Callback<Response>() {
            @Override
            public void success(Response gurunaviResponse, Response response) {

                // 結果のJsonからString型のresultを作成
                BufferedReader reader = null;
                StringBuilder sb = new StringBuilder();
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(response.getBody().in()));
                    String line;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String result = sb.toString();

                // 結果のJsonをString型にしてGurunaviSearchListenerのonSuccessに渡す。
                listener.onSuccess(result);
                Log.d("TAG", "success!!!!!");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG", "failed!!!!!");
                Log.d("TAG", error.toString());
            }
        });
    }


    //都道府県
    public void prefSearch(final String keyId, final  String format, final String lang, final GurunaviSearchListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(PREFSEARCH_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        GurunaviApiService service = restAdapter.create(GurunaviApiService.class);

        service.prefSearch(keyId, format, lang, new Callback<Response>() {
            @Override
            public void success(Response gurunaviResponse, Response response) {

                // 結果のJsonからString型のresultを作成
                BufferedReader reader = null;
                StringBuilder sb = new StringBuilder();
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(response.getBody().in()));
                    String line;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String result = sb.toString();

                // 結果のJsonをString型にしてGurunaviSearchListenerのonSuccessに渡す。
                listener.onSuccess(result);
                Log.d("TAG", "success!!!!!");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG", "failed!!!!!");
                Log.d("TAG", error.toString());
            }
        });
    }


    //エリアLマスタ
    public void GareaLSearch(final String keyId, final  String format, final String lang, final GurunaviSearchListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(AREAL_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        GurunaviApiService service = restAdapter.create(GurunaviApiService.class);

        service.GareaLSearch(keyId, format, lang, new Callback<Response>() {
            @Override
            public void success(Response gurunaviResponse, Response response) {

                // 結果のJsonからString型のresultを作成
                BufferedReader reader = null;
                StringBuilder sb = new StringBuilder();
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(response.getBody().in()));
                    String line;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String result = sb.toString();

                // 結果のJsonをString型にしてGurunaviSearchListenerのonSuccessに渡す。
                listener.onSuccess(result);
                Log.d("TAG", "success!!!!!");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG", "failed!!!!!");
                Log.d("TAG", error.toString());
            }
        });
    }




    //お店検索
    public void search(final String keyId, final  String format, final String freeWord, final GurunaviSearchListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(REQUEST_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        GurunaviApiService service = restAdapter.create(GurunaviApiService.class);

        service.search(keyId, format, freeWord, new Callback<Response>() {
            @Override
            public void success(Response gurunaviResponse, Response response) {



                // 結果のJsonからString型のresultを作成
                BufferedReader reader = null;
                StringBuilder sb = new StringBuilder();
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(response.getBody().in()));
                    String line;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String result = sb.toString();

                // 結果のJsonをString型にしてGurunaviSearchListenerのonSuccessに渡す。
                listener.onSuccess(result);
                Log.d("TAG", "success!!!!!");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG", "failed!!!!!");
                Log.d("TAG", error.toString());
            }
        });

    }
}

