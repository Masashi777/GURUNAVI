package com.lifeistech.android.gurunavi_sample;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lifeistech.android.gurunavi_sample.adapterClass.CustomAdapter;
import com.lifeistech.android.gurunavi_sample.gurunavi.Gurunavi;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviConnect;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.GurunaviResponse;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviRetrofit;
import com.lifeistech.android.gurunavi_sample.gurunavi.errorAPI.ErrorResponse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static CustomAdapter adapter;
    static ArrayList<Rest> rests = new ArrayList<Rest>();
    private String freeword;
    private int page = 1;


    //コネクタ
    GurunaviConnect connect = new GurunaviRetrofit();

    /*
    /Retrofiから直接も可能？
     */
//    GurunaviRetrofit retrofit = new GurunaviRetrofit();

    final Gurunavi gurunavi = new Gurunavi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        Intent intent = getIntent();
        freeword = intent.getStringExtra("freeword");
        Log.d("TAG", freeword);

        search();

//        listView.addFooterView(getApplicationContext());
        listView.setOnScrollListener(new onScrollListener());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "posituon" + position);

                detail(position);

            }
        });

        setTitle("検索結果");


    }


    public void search() {

        gurunavi.search(connect, freeword, page, new GurunaviConnect.GurunaviSearchListener() {

            @Override
            public void onSuccess(String result) {

                try {
                    // success
                    // json中の{}を""に変換
                    String regex = "\\{\\}";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(result);
                    String json = m.replaceAll("\"\"");

                    // String(中身はjson形式)から GurunaviResponse型への変換
                    Gson gson = new Gson();
                    GurunaviResponse gurunaviResponse = gson.fromJson(json, GurunaviResponse.class);

                    Log.d("TAG", gurunaviResponse.getRestList().get(0).getAddress());
                    Log.d("TAG", "success!!!!!");

                    //とりだす
                    ArrayList<Rest> rests = new ArrayList<>();

                    rests.addAll(gurunaviResponse.getRestList());

                    adapter = new CustomAdapter(getApplicationContext(), R.layout.activity_main, rests);
                    listView.setAdapter(adapter);

                    Log.d("TAG", rests.get(0).getName());


                } catch (Exception e) {
                    // error

                    // json中の{}を""に変換
                    String regex = "\\{\\}";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(result);
                    String json = m.replaceAll("\"\"");

                    // String(中身はjson形式)から GurunaviResponse型への変換
                    Gson gson = new Gson();
                    ErrorResponse errorResponse = gson.fromJson(json, ErrorResponse.class);

                    Log.d("ErrorCode", String.valueOf(errorResponse.getError().getCode()));
                    Log.d("Message", errorResponse.getError().getMessage().toString());

                    // エラーメッセージを表示
                    new AlertDialog.Builder(getApplicationContext())
                            .setTitle("エラーコード：" + errorResponse.getError().getCode())
                            .setMessage(errorResponse.getError().getMessage().toString())
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // OK button pressed
                                    search();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Cancel button pressed
                                    finish();
                                }
                            })
                            .show();
                }


            }

            @Override
            public void onFailed(String error) {

                Log.e("TAG", error);
            }

        });

    }

    public void detail(int position) {

        Intent intent = new Intent(this, DetailActivity.class);
        Rest rest = (Rest) listView.getAdapter().getItem(position);
        intent.putExtra("rest", rest);
        intent.setAction(Intent.ACTION_VIEW);
        Log.d("tag", rest.getImageURL().getShopImage1());
        startActivity(intent);

        Log.d("TAG", "ID" + position);

    }

    // リストの最後まで行ったら新しい要素を追加
    public class onScrollListener implements AbsListView.OnScrollListener{
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            if (totalItemCount == firstVisibleItem + visibleItemCount) {
                page++;
                search();
            }
        }
    }

}
