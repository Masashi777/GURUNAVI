package com.lifeistech.android.gurunavi_sample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Wearable;
import com.google.gson.Gson;
import com.lifeistech.android.gurunavi_sample.gurunavi.CustomAdapter;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

// MessageApi.MessageListener DataApi.DataListener

public class MainActivity extends WearableActivity implements MessageApi.MessageListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    final String DATA_PATH = "/path";

//    SharedPreferences preferences = getSharedPreferences("favList", MODE_PRIVATE);
//    SharedPreferences.Editor editor = preferences.edit();

    ListView listView;
    static CustomAdapter adapter;
    static ArrayList<Rest> favoriteList = new ArrayList<Rest>();

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        listView = (ListView) findViewById(R.id.listView);

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        //mClockView = (TextView) findViewById(R.id.clock);

        readyAPI();

        Gson gson = new Gson();
//        favoriteList = gson.fromJson(preferences.getString("favList", ""), Rest.class);
        adapter = new CustomAdapter(getApplicationContext(), R.layout.rest_list, favoriteList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "posituon" + position);

                Toast.makeText(getApplicationContext(), "Tapped" + position, Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                favoriteList.remove(position);
                adapter = new CustomAdapter(getApplicationContext(), R.layout.rest_list, favoriteList);
                listView.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "LongTapped" + position + id, Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    //readyAPI
    public void readyAPI() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }


    //DataAPI

    //データ受信
//    @Override
//    public void onDataChanged(DataEventBuffer dataEvents) {
//        Log.d("TAG", "データ更新");
//        for (DataEvent event : dataEvents) {
//            // TYPE_DELETEDがデータ削除時、TYPE_CHANGEDがデータ登録・変更時
//            if (event.getType() == DataEvent.TYPE_DELETED) {
//                Log.d("TAG", "DataItem deleted: " + event.getDataItem().getUri());
//
//            } else if (event.getType() == DataEvent.TYPE_CHANGED) {
//                Log.d("TAG", "DataItem changed: " + event.getDataItem().getUri());
//
//                // 更新されたデータを取得する
//                DataMap dataMap = DataMap.fromByteArray(event.getDataItem().getData());
//
//                byte[] bytes = new byte[0];
//
//                try {
//                    bytes = dataMap.getByteArray("favList");
//
//                    favoriteList = (ArrayList<Rest>) ByteConverter.toObject(bytes);
//
//                    adapter = new CustomAdapter(getApplicationContext(), R.layout.rest_list, favoriteList);
//                    listView.setAdapter(adapter);
//
//                    Log.d("TAG", favoriteList.get(0).getName());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return;
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                    return;
//                }
//
//            }
//        }
//    }

    //メッセージ受信
    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("TAG", "レシーブ");
        if (messageEvent.getPath().equals(DATA_PATH)) {
            byte[] bytes = new byte[0];

            try {
                bytes = messageEvent.getData();
                Rest rest;
                rest = (Rest) ByteConverter.toObject(bytes);

                favoriteList.add(rest);

                adapter = new CustomAdapter(getApplicationContext(), R.layout.rest_list, favoriteList);
                listView.setAdapter(adapter);

                Gson gson = new Gson();
                gson.toJson(favoriteList);
//                editor.putString("favList", gson.toJson(favoriteList)).commit();

                Log.d("TAG", rest.getName());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        googleApiClient.connect();


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (googleApiClient != null && googleApiClient.isConnected()) {
            Wearable.MessageApi.removeListener(googleApiClient, this);
            googleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Wearable.MessageApi.addListener(googleApiClient, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("TAG", "onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e("TAG", "onConnectionFailed: " + connectionResult);
    }


    //WEAR

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }

}
