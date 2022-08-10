package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.shop.Utils.NetConnection;

public class Splash extends AppCompatActivity implements NetConnection.ConnectivityReceiverListener {

    NetConnection netConnection;
    IntentFilter intentfilter;

    LinearLayout net;
    LinearLayout noNet;
    Button retry;

    private Context context;
    private Object NetConnection;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = Splash.this;
        netConnection = new NetConnection();
        intentfilter = new IntentFilter();
        intentfilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        net = findViewById(R.id.net);
        noNet = findViewById(R.id.noNet);
    }

        @Override
        protected void onResume () {
            super.onResume();
            Intent intent = registerReceiver(netConnection, intentfilter);
            netConnection.setConnectivityReceiverListener(this);
            boolean isConnected = com.example.shop.Utils.NetConnection.isConnected(this);
        }
        @Override
        protected void onDestroy(){
        super.onDestroy();
        try{
            unregisterReceiver(netConnection);
        }
        catch (IllegalArgumentException ex)
        {
            ex.printStackTrace();
        }

        }


        @Override

        public void onNetworkConnectionChanged(boolean isConnected){
            callInternet(isConnected);
        }

        private void callInternet(boolean isConnected){

            Log.e("internet check", String.valueOf(isConnected));

            if(isConnected) {
                net.setVisibility(View.VISIBLE);
                noNet.setVisibility(View.GONE);

                Handler handel = new Handler();
                handel.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent intent = new Intent(Splash.this, MainActivity.class);
                        startActivity(intent);

                    }
                }, 2000);
            } else {
                net.setVisibility(View.GONE);
                noNet.setVisibility(View.VISIBLE);
            }
        }
}


