package com.example.owner.grocehurry;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText username, password;
    private Button loginBtn, createAccountBtn, skipBtn;

    @Override
    public void onStart() {
        super.onStart();
         //FirebaseUser currentUser = auth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

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
        String user = username.getText().toString();
        String pass = password.getText().toString();
        auth.signInWithEmailAndPassword(user, pass)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = auth.getCurrentUser();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                    // ...
                }
            });
    }

    public void createAccount() {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        auth.createUserWithEmailAndPassword(user, pass)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Log.d("LOGIN","create user done!" );
                        Toast.makeText(
                                getApplicationContext(),
                                "New account created!",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(
                                getApplicationContext(),
                                "Account already Exists!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
    }

    public void skipLogin() {

    }
}
