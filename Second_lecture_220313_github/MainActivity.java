package com.example.a02_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClickLogo(View view){
        //자료 정보창 띄우는 객체 toast
        // 매개변수를 View로 받는다.
        Toast.makeText(this,"문의사항 : 000-000-000",Toast.LENGTH_LONG).show();
        // toast인자는 어디에 띄울것인지, 무슨내용을, 얼마만큼.show()로 보면된다.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 레이아웃 인플레이션?
        // setContentView 밑줄에서 xml에서 가져와 접근하는것을 작성.
        TextView textView=(TextView)findViewById(R.id.textViewMDQ);
        textView.setTextSize(20); // 20sp
        textView.setTextColor(Color.BLACK); // Black 설정
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD_ITALIC);
        // 인자 1 : typeface, 인자2 : 설정할 것



    }
}
