package com.example.a04_activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PwdActivity extends AppCompatActivity {
    TextView textViewInfo;
    Button buttonToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd);

        textViewInfo = findViewById(R.id.textViewInfo);
        buttonToMain = findViewById(R.id.buttonToMain);
        Intent intentR = getIntent();
        String sSno = intentR.getStringExtra("sno");
        String sMsg = getString(R.string.pwd_msg);
        textViewInfo.setText(sSno + sMsg);

        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}