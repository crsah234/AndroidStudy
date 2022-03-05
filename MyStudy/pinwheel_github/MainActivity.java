package com.example.pinwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
// onCreate는 자바 클래스가 호출할때 처음 실행되는 메소드.
        super.onCreate(savedInstanceState);
        // 액티비티 생성
        setContentView(R.layout.activity_main);
        //activity_main.xxml에서 정의된 화면 레이아웃을 액티비티에 출력.

        ImageView im = (ImageView) findViewById(R.id.pinwheel);
        // ImageView 객체 하나 생성하여 객체에 Id가 pinwheel인것을 인식시킴.

        ObjectAnimator object = ObjectAnimator.ofFloat(im, "rotation", 360);
        // 인식한 이미지를 360도 회전시키는 애니메이션 객체생성.
        // 목표, 어떻게, 몇도?(얼마나)

        object.setInterpolator((new LinearInterpolator()));
        // 객체 object의 보간을 설정함.
        // 보간은 두 점을 연결하는 방법이며 어떻게 궤적을 형성할 것인가를 나타냅니다.
        // Interpolator는
        // 시작시점과 종료시점까지의 변화 과정을 어떤식으로 표현 할 것 인가에 대한 것을 Animation으로 정의한 것
        //https://gus0000123.medium.com/android-animation-interpolar-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-8d228f4fc3c3
        // interpolator 관련 블로그 가져옴.
        //  LinearInterpolator은 일정한 속도로 움직이게 하는것을 의미함.
        object.setDuration(2000);
        // 애니메이션 시간을 0.001*2000=2초로 설정
        object.setRepeatCount(ValueAnimator.INFINITE);
        //애니메이션 반복을 무한번으로 설정
        object.start();
        //시작

//        ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
//        animation.setDuration(1000);
//        animation.start();

    }
}