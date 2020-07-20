package com.SoftwareInversion.withallah.java.withallah;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.SoftwareInversion.withallah.R;
import com.SoftwareInversion.withallah.java.withallah.Api.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class TimePrayers extends AppCompatActivity {

    protected TextView fajr;
    protected TextView duhur;
    protected TextView asr;
    protected TextView maghreb;
    protected TextView isha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_time_prayers);
        initView();
        ApiManager.apInterface().RESPONSE_CALL("cairo").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                fajr.setText(response.body().getResults().getDatetime().get(0).getTimes().getFajr());
                duhur.setText(response.body().getResults().getDatetime().get(0).getTimes().getDhuhr());
                asr.setText(response.body().getResults().getDatetime().get(0).getTimes().getAsr());
                maghreb.setText(response.body().getResults().getDatetime().get(0).getTimes().getMaghrib());
                isha.setText(response.body().getResults().getDatetime().get(0).getTimes().getIsha());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(TimePrayers.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initView() {
        fajr = (TextView) findViewById(R.id.fajr);
        duhur = (TextView) findViewById(R.id.duhur);
        asr = (TextView) findViewById(R.id.asr);
        maghreb = (TextView) findViewById(R.id.maghreb);
        isha = (TextView) findViewById(R.id.isha);
    }
}





