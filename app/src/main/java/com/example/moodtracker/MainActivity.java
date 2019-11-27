package com.example.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgHappy;
    private ImageView mClickCom;
    private ImageView mClickHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgHappy = findViewById(R.id.smiley);
        mClickCom = findViewById(R.id.com);
        mClickHistory = findViewById(R.id.history);
    }
}
