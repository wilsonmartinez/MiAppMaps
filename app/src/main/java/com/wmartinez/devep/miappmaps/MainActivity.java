package com.wmartinez.devep.miappmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irMapa(View view){
        double lat = 0.0;
        double lng = 0.0;
        int place = 0;
        switch (view.getId()){
            case R.id.imgPlaceOne:
                lat = 4.658396100607047;
                lng = -74.09427262331087;
                place = 1;
                break;
            case R.id.imgPlaceTwo:
                lat = 4.945941413288493;
                lng = -73.96177777685999;
                place = 2;
                break;
            case R.id.imgPlaceThree:
                lat = 4.605290306637615;
                lng = -74.0554783900394;
                place = 3;
                break;
            case R.id.imgPlaceFour:
                lat = 4.598120022006617;
                lng = -74.0760422079693;
                place = 4;
                break;

        }
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("latitud", lat);
        intent.putExtra("longitud", lng);
        intent.putExtra("place", place);
        startActivity(intent);
    }
}
