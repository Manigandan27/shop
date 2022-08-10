package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shop.Utils.NetConnection;

public class Login extends AppCompatActivity implements NetConnection.ConnectivityReceiverListener {


    NetConnection netConnection;
    IntentFilter intentfilter;
    LinearLayout net1;
    LinearLayout noNet1;
//    Button retry;
    private Context context;
    private Object NetConnection;
    Button BLogin, PasswordBack;
    TextView TLogin,TPassword;
    EditText Ed1, Ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        BLogin = findViewById(R.id.BLogin);
        TLogin = findViewById(R.id.TLogin);
        TPassword=findViewById(R.id.TPassword);
    //    Button retry = findViewById(R.id.retry);
        Ed1 = findViewById(R.id.Ed1);
        Ed2 = findViewById(R.id.Ed2);

        netConnection = new NetConnection();
        intentfilter=new IntentFilter();
        net1 = findViewById(R.id.net1);
        noNet1 = findViewById(R.id.noNet1);
        intentfilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        PasswordBack = findViewById(R.id.PasswordBack);


        BLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Ed1.getText().toString().trim().equals("123456") && Ed2.getText().toString().trim().equals("123456")) {
                    Intent myInt = new Intent(Login.this, MainActivity.class);
                    startActivity(myInt);
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Data", Toast.LENGTH_SHORT).show();

                }

            }
        });

        TLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myInt = new Intent(Login.this, Home.class);
                startActivity(myInt);

            }
        });

        TPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myInt = new Intent(Login.this, ForgotPassword.class);
                startActivity(myInt);
            }
        });
    }


            @Override
            protected void onResume() {
            super.onResume();
                registerReceiver(netConnection, intentfilter);
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

    private void callInternet(boolean isConnected) {

        Log.e("internet check", String.valueOf(isConnected));

        if (isConnected) {
            net1.setVisibility(View.VISIBLE);
            noNet1.setVisibility(View.GONE);

        } else {
            net1.setVisibility(View.GONE);
            noNet1.setVisibility(View.VISIBLE);

            };
        }
    }



