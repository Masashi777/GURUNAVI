package com.lifeistech.android.gurunavi_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.Rest;
import com.squareup.picasso.Picasso;

import static java.lang.Double.parseDouble;

public class ScrollingActivity extends AppCompatActivity implements OnMapReadyCallback {

    AppBarLayout appBarLayout;

    Rest rest;


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
        setContentView(R.layout.activity_scrolling);
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

        budgetText.setText("平均予算 " + rest.getBudget() + " パーティー " + rest.getParty() + " ランチ " + rest.getLunch());
        opentimeText.setText(rest.getOpentime());
        accessText.setText(rest.getAccess().getStation() + rest.getAccess().getStationExit() + rest.getAccess().getWalk());

        prText.setText(rest.getPr().getPrShort());

        Picasso.with(this).load(rest.getImageURL().getShopImage1()).into(shopImage1);

        if (rest.getImageURL().getShopImage2().length() != 0) {
            Picasso.with(this).load(rest.getImageURL().getShopImage2()).into(shopImage2);
        } else {
            //ShopImage2がないときは何もしない
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        latLng = new LatLng(parseDouble(rest.getLatitude()), parseDouble(rest.getLongitude()));
        mMap.addMarker(new MarkerOptions().title(rest.getName()).position(latLng));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }

}
