package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView tv_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        PreferenceManager.init(this);
        Log.e("sp", PreferenceManager.getUserName());
        tv_username.setText(PreferenceManager.getUserName());
    }

    private void init() {
        tv_username = findViewById(R.id.tv_username);
    }
}