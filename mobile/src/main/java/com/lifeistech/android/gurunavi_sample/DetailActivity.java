package com.lifeistech.android.gurunavi_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    final String DATA_PATH = "/path";
    DataMap dataMap = new DataMap();

    AppBarLayout appBarLayout;

    Rest rest;
    static ArrayList<Rest> favoriteList = new ArrayList<Rest>();

    ImageView shopImage1;
    ImageView shopImage2;

    TextView nameText;
    TextView addressText;

    TextView budgetText;
    TextView opentimeText;
    TextView accessText;

    TextView prText;

    private GoogleMap mMap;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //ひもづけ
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);

        shopImage1 = (ImageView) findViewById(R.id.shopImage1);
        shopImage2 = (ImageView) findViewById(R.id.shopImage2);

        nameText = (TextView) findViewById(R.id.nameText);
        addressText = (TextView) findViewById(R.id.addressText);

        budgetText = (TextView) findViewById(R.id.budgetText);
        opentimeText = (TextView) findViewById(R.id.opentimeText);
        accessText = (TextView) findViewById(R.id.accessText);

        prText = (TextView) findViewById(R.id.prText);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        //インテントから取得
        Intent intent = getIntent();
        rest = (Rest) intent.getSerializableExtra("rest");

        //それぞれに表示
        nameText.setText(rest.getName());
        addressText.setText(rest.getAddress());

        budgetText.setText("平均予算 " + rest.getBudget() + "円 パーティー " + rest.getParty() + "円 ランチ " + rest.getLunch() + "円");
        opentimeText.setText(rest.getOpentime());
        accessText.setText(rest.getAccess().getStation() + rest.getAccess().getStationExit() + " 徒歩" + rest.getAccess().getWalk() + "分");

        prText.setText(rest.getPr().getPrShort());

//        Picasso.with(this).load(rest.getImageURL().getShopImage1()).into(shopImage1);

        if (rest.getImageURL().getShopImage2().length() != 0) {
            Picasso.with(this).load(rest.getImageURL().getShopImage2()).into(shopImage2);
        } else {
            //ShopImage2がないときは何もしない
        }

        //DataAPI
        readyAPI();


    }


    public void readyAPI() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        latLng = new LatLng(parseDouble(rest.getLatitude()), parseDouble(rest.getLongitude()));
        mMap.addMarker(new MarkerOptions().title(rest.getName()).position(latLng));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }

    public void add(View v) {

        //DataMap

//        // DataMap object の生成、毎回違う値を送信
//
//        // DataMapインスタンスを生成する
//        PutDataMapRequest dataMapRequest = PutDataMapRequest.create(DATA_PATH);
//        dataMap = dataMapRequest.getDataMap();
//
//        // データをセットする
//
//        byte[] bytes = new byte[0];
//
//        try {
//            favoriteList.add(rest);
//            bytes = ByteConverter.fromObject(favoriteList);
//            dataMap.putByteArray("favList", bytes);
//            Log.d("TAG", favoriteList.get(0).getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // データを更新する
//        PutDataRequest request = dataMapRequest.asPutDataRequest();
//        PendingResult<DataApi.DataItemResult> pendingResult = Wearable.DataApi.putDataItem(googleApiClient, request);
//        pendingResult.setResultCallback(new ResultCallback<DataApi.DataItemResult>() {
//            @Override
//            public void onResult(DataApi.DataItemResult dataItemResult) {
//                Log.d("TAG", "onResult: " + dataItemResult.getStatus());
//            }
//        });

        // UI がブロックするかもしれないので新しくThreadを立てる
//        new SendToDataLayerThread(DATA_PATH, dataMap).start();


        //メッセージ送信

        PendingResult<NodeApi.GetConnectedNodesResult> nodes = Wearable.NodeApi.getConnectedNodes(googleApiClient);
        nodes.setResultCallback(new ResultCallback<NodeApi.GetConnectedNodesResult>() {
            @Override
            public void onResult(NodeApi.GetConnectedNodesResult result) {

                for (Node node : result.getNodes()) {
                    byte[] bytes = new byte[0];

                    try {
                        bytes = ByteConverter.fromObject(rest);
                        PendingResult<MessageApi.SendMessageResult> messageResult = Wearable.MessageApi.sendMessage(googleApiClient, node.getId(), DATA_PATH, bytes);

                        messageResult.setResultCallback(new ResultCallback<MessageApi.SendMessageResult>() {
                            @Override
                            public void onResult(MessageApi.SendMessageResult sendMessageResult) {
                                Status status = sendMessageResult.getStatus();
                                Log.d("TAG", "Status: " + status.toString());
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }

    public void favorite(View v) {
        Intent intent = new Intent(this, FavoriteActivity.class);
        startActivity(intent);
    }

    //DataAPI

    //DataAPIデータ送信用

    // data layer へ送るための Thread
//    class SendToDataLayerThread extends Thread {
//        String path;
//        DataMap dataMap;
//
//        SendToDataLayerThread(String p, DataMap data) {
//            path = DATA_PATH;
//            dataMap = data;
//        }
//
//        public void run() {
//            NodeApi.GetConnectedNodesResult nodes = Wearable.NodeApi.getConnectedNodes(googleApiClient).await();
//            for (Node node : nodes.getNodes()) {
//
//                PutDataMapRequest putDMR = PutDataMapRequest.create(path);
//
//                putDMR.getDataMap().putAll(dataMap);
//                PutDataRequest request = putDMR.asPutDataRequest();
//                DataApi.DataItemResult result = Wearable.DataApi.putDataItem(googleApiClient, request).await();
//
//                if (result.getStatus().isSuccess()) {
//                    Log.d("TAG", "DataMap: " + dataMap + " sent to: " + node.getDisplayName());
//                } else {
//                    Log.d("TAG", "ERROR");
//                }
//            }
//        }
//    }


    @Override
    protected void onResume() {
        super.onResume();
        googleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (googleApiClient != null && googleApiClient.isConnected()) {
//            Wearable.DataApi.removeListener(googleApiClient, this);
            googleApiClient.disconnect();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("TAG", "onConnectionFailed()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    // 接続時
    @Override
    public void onConnected(Bundle connectionHint) {
//        Wearable.DataApi.addListener(googleApiClient, this);
        Log.d("TAG", "onConnected()");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("TAG", "onConnectionSuspended()");
    }
    // Activity が止まったら切断する
    @Override
    protected void onStop() {
        if (null != googleApiClient && googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
        super.onStop();
    }

}
