package com.lifeistech.android.gurunavi_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ScrollingActivity extends AppCompatActivity implements OnMapReadyCallback {

    AppBarLayout appBarLayout;

    TextView nameText;
    TextView addressText;
    TextView prText;

    private GoogleMap mMap;

    private String name;
    private String address;
    private String pr;

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
        appBarLayout =(AppBarLayout) findViewById(R.id.app_bar);
        nameText = (TextView) findViewById(R.id.nameText);
        addressText = (TextView) findViewById(R.id.addressText);
        prText = (TextView) findViewById(R.id.prText);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        //インテントから取得
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        pr = intent.getStringExtra("pr");

        //それぞれに表示
        nameText.setText(name);
        addressText.setText(address);
        prText.setText(pr);

        appBarLayout.setBackgroundResource(R.drawable.mig);

        //imageView.setImageResource(R.drawable.mig);
        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng latLng = new LatLng(35, 135);
        mMap.addMarker(new MarkerOptions().title("akashi").position(latLng));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
    }

}
