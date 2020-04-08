package com.example.qoscheckapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.qoscheckapp.broadcastReceiver_jobService.ServiceIntentBR;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ServiceIntentBR.scheduleJob(getApplicationContext());
        }else{
            HelperServiceClass.launchService(getApplicationContext());
        }
        finish();
    }
}
