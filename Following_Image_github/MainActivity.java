package com.example.following_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {
    // app bar와 status바가 안보이고,  fullscreen으로 설정해야함. 1.

    // 화면 상단에 상태 바(status bar)와 앱 바가 나타나지 않는 full screen으로 만들기 위해
    // AppCompatactivity를 수정함. ->FragmentActivity로.

    ImageView iv_smile;
    float previous_x = 0;
    float previous_y = 0;

    //전역변수로 설정하는 이유는 초기값을 바꿔주기위함. 터
    // 치를 해제했을때의 좌표가 다시 사진의 초기값이 되어야하기에 전역변수로 설정.

    Vibrator mVibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 엑티비티 생성
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //setFlags 중 Flag에 관한 내용 https://onlyfor-me-blog.tistory.com/201
        // 화면을 full screen으로 만들것임
        // 그러므로
        // 윈도우에서 가져와서(getWindow), flags을 세팅해줌(setFlags).
        // 그다움 윈도우매니저가 세팅을해주는데(WindowManager)
        // 무엇을 세팅해주느냐, LayerParams들을 세팅해준다(LayerParams)
        // FLAGS_FULLSCREEN으로 세팅해줌.

        // window-flags-windowmanager-Layerparams접근, FLAG_FULLSCREEN
        // 위의 전체화면으로 만드는 코드는 setContentView 위에 써야함. **

        // 비고
        // StatusBar를 제거할려면
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //TitleBar를 제거할려면
        //requestWindowFeature(Window.FEATURE_NO_TITLE

        setContentView(R.layout.activity_main);

        iv_smile = (ImageView) findViewById(R.id.p);

        mVibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // 진동을 위해 하드웨어에 접근이 가능한 진동객체를 생성
        //  getSystemService(Context.기능) 인거같음.

    }

    @Override   // boolean을 반환하는 onTouchEvent 함수, 인자값은 MotionEvent  이다.
    public boolean onTouchEvent(MotionEvent event) {
        // 터치 시에 시스템에 의해 호출됨

        // 안드로이드의 View는 터치이벤트를 받을 수 있고, Activity도 터치이벤드를 받을 수 있다.
        //View에 이 이벤트를 처리하려면 2가지의 방법이 있는데, 한가지는 View가 기본적으로 가지고 있는 onTouchEvent를 오버라이드하는 것,
        // 이번 안드로이드는 후자를 이용함

        // 다른 한가지는 setOnTouchListener()함수를 통하여 인터페이스가 적용된 객체를 지정하는 방법이 있다.
        //출처: https://jamssoft.tistory.com/161 [What should I do?]

        // switch문을 만듬.
        // 경우는 3가지.
        //첫째 : 누르기 시작할때(UP), 둘째 : 누르고 있을경우(MOVE) 셋째 : 누른게 끝났을 경우
        // 사진이 누른 곳으로 이동하려면 누르고 있을경우를 상정해서 설정해야함.
        switch (event.getAction()) { //경우를 나누는 기준은 event.getAction 터치 이벤트의 값임.
            // 터치시 액션을 가져와라
            case MotionEvent.ACTION_DOWN:
                // 누르기 시작할때
                break;

            case MotionEvent.ACTION_MOVE:
                //터치하고 움직이는 상태일 때
                // 현재의 xy값을가져와서 이전의 값, 즉 직전의 사진의 좌표를, 가져온 현재의 좌표값으로 옮기는 것을 수행.
                // 지역변수로설정하는 이유는 이 함수 안에서만 돌아갸아하는 작업이기때문임.
                int touch_x = (int) event.getX();
                int touch_y = (int) event.getY();
                //  터치하고 있는 x,y의 위치 인식

                //수행 방식은 ObjectAnimator의 메소드 ofFLoat을 이용하여
                // translationX, translationY 를 이전의 x값에서 현재 x값으로 변경하는 작업을 수행한다.
                ObjectAnimator smileX = ObjectAnimator.ofFloat(iv_smile,
                        "translationX", previous_x, touch_x);

                ObjectAnimator smileY = ObjectAnimator.ofFloat(iv_smile,
                        "translationY", previous_y, touch_y);

                smileX.start();
                smileY.start();  //애니메이터 시작
                // 이미지의 x,y좌표를 이전 위치(previous_x, previous_y)에서 현재위치(touch_x, touch_y)로 이동.
                mVibe.vibrate(50);
                // 진동 설정.

                previous_x = touch_x;
                previous_y = touch_y;
                //현재 위치를 이전 위치로 설정 - > 다음 모션 이벤트 대비하기 위함.
                break;
            case MotionEvent.ACTION_UP:
                // 터치 후 손을 떼는 상태일때
                break;

        }
        return false;

    }

}