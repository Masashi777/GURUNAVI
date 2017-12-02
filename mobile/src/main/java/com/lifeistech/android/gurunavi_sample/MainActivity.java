package com.lifeistech.android.gurunavi_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lifeistech.android.gurunavi_sample.adapterClass.CustomAdapter;
import com.lifeistech.android.gurunavi_sample.gurunavi.Gurunavi;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviConnect;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.GurunaviResponse;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviRetrofit;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    ListView listView;
    static CustomAdapter adapter;
    static ArrayList<Rest> rests = new ArrayList<Rest>();
    private final String keyId = "198d3912d63f7394f59748a3a797e742";
    private final String format = "json";
    private String freeword;


    //コネクタ
    GurunaviConnect connect = new GurunaviRetrofit();

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "posituon" + position);

                detail(position);

            }
        });

    }

    public void search() {

        gurunavi.search(connect, keyId, format, freeword, new GurunaviConnect.GurunaviSearchListener() {

            @Override
            public void onSuccess(String result) {

                //json中の{}を""に変換
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
}
