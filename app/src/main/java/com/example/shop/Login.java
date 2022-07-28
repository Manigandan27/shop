package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

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

        Ed1 = findViewById(R.id.Ed1);
        Ed2 = findViewById(R.id.Ed2);

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
}