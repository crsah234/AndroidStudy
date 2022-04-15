package com.example.a04_activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button  buttonLogin, buttonPwd;
    EditText editTextSNo, editTextPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// 레이아웃 인플레이션
        buttonLogin=findViewById(R.id.buttonLogin);
        buttonPwd=findViewById(R.id.buttonPwd);
        editTextPwd=findViewById(R.id.editTextPassword);
        editTextSNo=findViewById(R.id.editTextSNo);

        buttonPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSno=editTextSNo.getText().toString();
                sSno=sSno.trim();

                if(sSno.isEmpty()){
                    Toast.makeText(MainActivity.this, "학번을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent=new Intent(getApplicationContext(),PwdActivity.class);
                intent.putExtra("sno",sSno);
                startActivity(intent);
            }
        });
    }

    public void onClickLogo(View view) {
        Uri uri = Uri.parse("geo:37.50014293285583, 126.86787227062011");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void onClickTitle(View view){
    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01067114740"));
    startActivity(intent);
    }
}