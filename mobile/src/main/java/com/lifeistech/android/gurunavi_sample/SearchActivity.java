package com.lifeistech.android.gurunavi_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText) findViewById(R.id.editText);
    }

    public void search(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("freeword", editText.getText().toString());
        startActivity(intent);

        Log.d("TAG", "go to Main" + editText.getText().toString());
    }

}
