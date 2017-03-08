package com.lifeistech.android.gurunavi_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.lifeistech.android.gurunavi_sample.adapterClass.AreaAdapter;
import com.lifeistech.android.gurunavi_sample.adapterClass.PrefAdapter;
import com.lifeistech.android.gurunavi_sample.gurunavi.GareaLSearchAPI.GareaLargeResponse;
import com.lifeistech.android.gurunavi_sample.gurunavi.Gurunavi;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviConnect;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviRetrofit;
import com.lifeistech.android.gurunavi_sample.gurunavi.areaSearchAPI.Area;
import com.lifeistech.android.gurunavi_sample.gurunavi.areaSearchAPI.AreaResponse;
import com.lifeistech.android.gurunavi_sample.gurunavi.prefSearchAPI.Pref;
import com.lifeistech.android.gurunavi_sample.gurunavi.prefSearchAPI.PrefResponse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchActivity extends AppCompatActivity {

    EditText editText;
    Spinner areaSpinner;
    Spinner prefSpinner;
    Spinner areaLSpinner;


    static AreaAdapter areaAdapter;
    static PrefAdapter prefAdapter;
    static ArrayList<Area> areas = new ArrayList<Area>();
    static ArrayList<Pref> prefs = new ArrayList<Pref>();

    private final String keyId = "9ffa01190536dce72adf62e5fba762be";
    private final String format = "json";
    private final String lang = "ja";

    //エリア取得のためのコネクタ作成
    GurunaviConnect connect = new GurunaviRetrofit();

    final Gurunavi gurunavi = new Gurunavi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText) findViewById(R.id.editText);
        areaSpinner = (Spinner) findViewById(R.id.areaSpinner);
        prefSpinner = (Spinner) findViewById(R.id.prefSpinner);
        areaLSpinner = (Spinner) findViewById(R.id.areaLSpinner);

        //エリアを取得
        areaSearch();
        //都道府県取得
        prefSearch();

    }


    public void areaSearch() {
        gurunavi.areaSearch(connect, keyId, format, lang, new GurunaviConnect.GurunaviSearchListener() {

            @Override
            public void onSuccess(String result) {

                //json中の{}を""に変換
                String regex = "\\{\\}";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(result);
                String json = m.replaceAll("\"\"");

                // String(中身はjson形式)から GurunaviResponse型への変換
                Gson gson = new Gson();
                AreaResponse areaResponse = gson.fromJson(json, AreaResponse.class);

                Log.d("TAG", areaResponse.getAreaList().get(0).getArea_name());
                Log.d("TAG", "Areasuccess!!!!!");

                //とりだす
                areas.addAll(areaResponse.getAreaList());

                areaAdapter = new AreaAdapter(getApplicationContext(), R.layout.area_list, areas);
                areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                areaSpinner.setAdapter(areaAdapter);

                Log.d("TAG", prefs.get(0).toString());

            }

            @Override
            public void onFailed(String error) {
                Log.e("TAG", error);
            }

        });


    }


    public void prefSearch() {
        gurunavi.prefSearch(connect, keyId, format, lang, new GurunaviConnect.GurunaviSearchListener() {

            @Override
            public void onSuccess(String result) {

                //json中の{}を""に変換
                String regex = "\\{\\}";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(result);
                String json = m.replaceAll("\"\"");

                // String(中身はjson形式)から GurunaviResponse型への変換
                Gson gson = new Gson();
                PrefResponse prefResponse = gson.fromJson(json, PrefResponse.class);

                Log.d("TAG", prefResponse.getPrefList().get(0).getPref_name());
                Log.d("TAG", "PrefSuccess!!!!!");

                //とりだす
                prefs.addAll(prefResponse.getPrefList());

                prefAdapter = new PrefAdapter(getApplicationContext(), R.layout.area_list, prefs);
                prefAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                prefSpinner.setAdapter(prefAdapter);

                Log.d("TAG", prefs.get(0).toString());

            }

            @Override
            public void onFailed(String error) {
                Log.e("TAG", error);
            }

        });


    }




    //検索ボタン
    public void search(View v) {

        if (editText.length() != 0) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("freeword", editText.getText().toString());
            startActivity(intent);

            Log.d("TAG", "go to Main" + editText.getText().toString());
        } else {
            Snackbar.make(v, "キーワードを入力してください", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }

    }

}
