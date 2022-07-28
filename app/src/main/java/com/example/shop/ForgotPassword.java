package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPassword extends AppCompatActivity {

    Button PasswordBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        PasswordBack = findViewById(R.id.PasswordBack);

        PasswordBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myInt = new Intent(ForgotPassword.this, Login.class);
                startActivity(myInt);

            }
        });
    }
}