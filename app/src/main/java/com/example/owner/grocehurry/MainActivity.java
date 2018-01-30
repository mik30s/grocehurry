package com.example.owner.grocehurry;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button loginBtn, createAccountBtn, skipBtn;
    private final  AccountDatabaseHelper accountDatabaseHelper
            = new AccountDatabaseHelper(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skipBtn = findViewById(R.id.skipBtn);
        loginBtn = findViewById(R.id.loginBtn);
        username = findViewById(R.id.usernameEditTxt);
        password = findViewById(R.id.passwordEditTxt);
        createAccountBtn= findViewById(R.id.createAccountBtn);

        skipBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {skipLogin();}
        });

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {login();}
        });

        createAccountBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {createAccount();}
        });
    }

    public void login() {

    }

    public void createAccount() {
    }

    public void skipLogin() {

    }
}
