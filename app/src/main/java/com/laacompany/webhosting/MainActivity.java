package com.laacompany.webhosting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSee;
    TextView tv1,tv2,tv3;
    String text1,text2,text3;

    public static final String KEY_TEXT_1 ="text1";
    public static final String KEY_TEXT_2 ="text2";
    public static final String KEY_TEXT_3 ="text3";
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSee = findViewById(R.id.btn_see);

        btnSee.setOnClickListener(this);


    }


    private void refresh(){

        Ion.with(getApplicationContext()).load("https://christoted.000webhostapp.com").asString().setCallback(
                new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
//                tv.setText(result);
                if (result == null || result.isEmpty()) return;
                String[] texts = result.split("#");
                if (texts.length == 4){
              //      tv1.setText(texts[1]);
              //      tv2.setText(texts[2]);
                    //     tv3.setText(texts[3]);
                    text1 = texts[1];
                    text2 = texts[2];
                    text3 = texts[3];
                    Log.d("TAG", "intent result: " + text1 + text2 + text3);
                }
//                tv1.setText(result);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if ( v == btnSee) {
            Intent intent = new Intent(MainActivity.this,ParkingActivity.class);
            startActivity(intent);
        }
    }
}
