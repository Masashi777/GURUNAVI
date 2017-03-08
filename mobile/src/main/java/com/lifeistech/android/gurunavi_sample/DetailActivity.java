package com.lifeistech.android.gurunavi_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class DetailActivity extends Activity implements OnMapReadyCallback {

    ImageView imageView;

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
        setContentView(R.layout.activity_detail);

        //ひもづけ
        imageView = (ImageView) findViewById(R.id.imageView2);
        nameText = (TextView) findViewById(R.id.nameText);
        addressText = (TextView) findViewById(R.id.addressText);
        prText = (TextView) findViewById(R.id.prText);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
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

        //imageView.setImageResource(R.drawable.mig);
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng latLng = new LatLng(35, 135);
        mMap.addMarker(new MarkerOptions().title("akashi").position(latLng));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
    }

}