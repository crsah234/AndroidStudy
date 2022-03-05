package com.example.first_lecture_print;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      위의   setContentView(R.layout.activity_main);
//      : acitivity_main.xml 을 가져와서 화면에 띄우는 내용

        TextView t1=findViewById(R.id.t1);
//        TextView 객체 생성, findViewById를 통해 메인 xml의 텍스트뷰와 여기서 연결함
        // 연결 후  밑에는 연결한 텍뷰의 기능을 추가시키는? 것.
        // 안드로이드에서 리소스를 사용시 두가지로 나뉜다.
        //1. xml에서 사용할때 : @리소스유형/리소스이름
        // 2. 자바에서 사용시 : R.리소스유형.리소스이름

//        리소스 사용방법
//        - java code : R.리소스 유형.리소스이름
//        ex) R.layout.activity_main
//
//        - xml파일 : @리소스유형/리소스이름
//        ex) @drawble/pinwheel
    //    t1.setText(R.string.app_name);
        t1.setText("20185047 김지호 \n생년원일:990427");

        // 교수님 수업중 exceptional 상황 만들어보기.
      //  TextView textview = null;
       // textview.setText("안녕!");
// Caused by: java.lang.NullPointerException:
// Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
        //생성되지 않은 객체를 메소드를 호출해 사용했기에 발생한 오류라는 뜻
        // Logcat에서 확인가능.



    }
}