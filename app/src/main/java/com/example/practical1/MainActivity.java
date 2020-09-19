package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_username,et_password;
    private Button btn_signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        PreferenceManager.init(this);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        if (username.isEmpty()){
            et_username.setError("Username is required");
            et_username.requestFocus();
        }else if (password.isEmpty()){
            et_password.setError("Password is required");
            et_password.requestFocus();
        }else {
            signIn(username, password);
        }
    }

    private void signIn(String username, String password) {
        if (username.equals("paraspatel") && password.equals("12345678")){
            PreferenceManager.setUsername(username);
            Intent intent = new Intent(MainActivity.this, SplashActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Sign in fail", Toast.LENGTH_LONG).show();
        }
    }


    private void init() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_signIn = findViewById(R.id.btn_signin);
    }
}