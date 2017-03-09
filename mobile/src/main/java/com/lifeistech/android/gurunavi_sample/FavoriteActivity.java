package com.lifeistech.android.gurunavi_sample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.lifeistech.android.gurunavi_sample.adapterClass.CustomAdapter;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;

import java.io.IOException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity implements DataApi.DataListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    final String DATA_PATH = "/path";
    DataMap dataMap = new DataMap();

    static CustomAdapter adapter;
    static ArrayList<Rest> favoriteList = new ArrayList<Rest>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        readyAPI();

        PendingResult<DataItemBuffer> dataItems = Wearable.DataApi.getDataItems(googleApiClient);
        dataItems.setResultCallback(new ResultCallback<DataItemBuffer>() {
            @Override
            public void onResult(DataItemBuffer dataItems) {
                for (DataItem dataItem : dataItems) {
                    if (dataItem.getUri().getPath().equals(DATA_PATH)) {
//                        dataMap = DataMap.fromByteArray(dataItem.getData());

                        byte[] bytes = new byte[0];

                        dataMap = DataMap.fromByteArray(dataItem.getData());
                        Log.d("ReceiceService", "DataMap received on watch: " + dataMap);
                        try {
                            bytes = dataMap.getByteArray("FavoriteData");
                            favoriteList = (ArrayList<Rest>) ByteConverter.toObject(bytes);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }
        });
    }

    public void readyAPI() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("TAG", "onConnectionFailed()");
    }


    //DataAPIデータ送信用

    // data layer へ送るための Thread
    class SendToDataLayerThread extends Thread {
        String path;

        SendToDataLayerThread(String p, DataMap data) {
            path = p;
            dataMap = data;
        }

        public void run() {
            NodeApi.GetConnectedNodesResult nodes = Wearable.NodeApi.getConnectedNodes(googleApiClient).await();
            for (Node node : nodes.getNodes()) {

                PutDataMapRequest putDMR = PutDataMapRequest.create(path);

                putDMR.getDataMap().putAll(dataMap);
                PutDataRequest request = putDMR.asPutDataRequest();
                DataApi.DataItemResult result = Wearable.DataApi.putDataItem(googleApiClient, request).await();

                if (result.getStatus().isSuccess()) {
                    Log.d("TAG", "DataMap: " + dataMap + " sent to: " + node.getDisplayName());
                } else {
                    Log.d("TAG", "ERROR");
                }
            }
        }
    }

    //データ受信用
    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Log.d("ReceiceService", "DonDataChanged() ");

        for (DataEvent event : dataEvents) {

            // Check the data type
            if (event.getType() == DataEvent.TYPE_CHANGED) {
                // Check the data path
                String path = event.getDataItem().getUri().getPath();
                if (path.equals(DATA_PATH)) {

                    byte[] bytes = new byte[0];

                    dataMap = DataMapItem.fromDataItem(event.getDataItem()).getDataMap();
                    Log.d("ReceiceService", "DataMap received on watch: " + dataMap);
                    try {
                        bytes = dataMap.getByteArray("FavoriteData");
                        favoriteList = (ArrayList<Rest>) ByteConverter.toObject(bytes);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return;
                    }


                    adapter = new CustomAdapter(getApplicationContext(), R.layout.activity_favorite, favoriteList);
                    listView.setAdapter(adapter);

                    // Local Broadcast
                    Intent messageIntent = new Intent();
                    messageIntent.setAction(Intent.ACTION_SEND);
                    messageIntent.putExtra("receivedData",bytes);
                    LocalBroadcastManager.getInstance(this).sendBroadcast(messageIntent);

                }


            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    // 接続時
    @Override
    public void onConnected(Bundle connectionHint) {
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
