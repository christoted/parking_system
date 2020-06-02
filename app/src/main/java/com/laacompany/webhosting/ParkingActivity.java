package com.laacompany.webhosting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class ParkingActivity extends AppCompatActivity {
    public static final String KEY_TEXT_1 ="text1";
    public static final String KEY_TEXT_2 ="text2";
    public static final String KEY_TEXT_3 ="text3";
    TextView tv_parking_status,tv_parking_status2,tv_parking_status3;
    TextView tv_status,tv_status2,tv_status3;
    private Handler handler = new Handler();
    String tv_parking_stat,tv_parking_stat2,tv_parking_stat3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        tv_parking_status = findViewById(R.id.tv_parking_status);
        tv_parking_status2 = findViewById(R.id.tv_parking_status2);
        tv_parking_status3 = findViewById(R.id.tv_parking_status3);
        tv_status = findViewById(R.id.tv_status);
        tv_status2 = findViewById(R.id.tv_status2);
        tv_status3 = findViewById(R.id.tv_status3);


        handler.postDelayed(runnable, 300);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //Do your refreshing
            refresh();
            //This basically reruns this runnable in 0.3 seconds
            handler.postDelayed(this, 300);
        }
    };

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
                            tv_parking_stat  = texts[1];
                            tv_parking_stat2 = texts[2];
                            tv_parking_stat3 = texts[3];

                            if ( tv_parking_stat.equals("1")) {
                                tv_parking_status.setText(tv_parking_stat);
                                tv_status.setText("Availability");

                            } else {
                                tv_parking_status.setText(tv_parking_stat);
                                tv_status.setText("Not Availability");
                                tv_status.setTextColor(Color.RED);
                            }

                            if ( tv_parking_stat2.equals("1")) {
                                tv_parking_status2.setText(tv_parking_stat2);
                                tv_status2.setText("Availability");
                            } else {
                                tv_parking_status2.setText(tv_parking_stat2);
                                tv_status2.setText("Not Availability");
                                tv_status2.setTextColor(Color.RED);
                            }

                            if ( tv_parking_stat3.equals("1")) {
                                tv_parking_status3.setText(tv_parking_stat3);
                                tv_status3.setText("Availability");
                            } else {
                                tv_parking_status3.setText(tv_parking_stat3);
                                tv_status3.setText("Not Availability");
                                tv_status3.setTextColor(Color.RED);
                            }
                            Log.d("TAG", "intent result: " + tv_parking_stat + tv_parking_stat2 + tv_parking_stat3);
                        }
//                tv1.setText(result);
                    }
                });
    }

}
