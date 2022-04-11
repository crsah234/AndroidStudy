package com.example.l03_review;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    TextView textViewTitle, textViewDept1, textViewDept2;
    // 3개의 텍스트뷰 연결
    ImageView imageViewDept1, imageViewDept2;
    // 2개의 이미지뷰 연결 - 조그마한사진 2개있는것.

    public void onClickInfo(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "홈페이지 전형 요강을 참고하세요", Toast.LENGTH_SHORT);
        toast.show();
        // 밑과 달리 토스트 객체를 생성및 생성한 객체.show();
        // 자식뷰를 제외한 부모뷰만 클릭시 토스트 띄우기
        // 그러기 위해 자식뷰에 clickable을 주어 부모뷰와 클릭이 구분되게 함.
    }

    public void onClickLogo(View view) {
        //자료 정보창 띄우는 객체 toast
        // 온클릭 메소드는 View를 매개변수로 가져옴.
        Toast.makeText(this, R.string.tel, Toast.LENGTH_LONG).show();
    }

    public void onClickDeptInfo(View view) {
        // 이메소드는 두개의 텍스트뷰의 적용됨. 각각에 매칭되는 것으로 실행하게끔 나눔.
        int r_id = view.getId();
        String sMsg = "";
        if (r_id == R.id.textViewMDQ) {
            sMsg=getString(R.string.msgmq);
        } else if (r_id == R.id.textViewMDC)
            sMsg=getString(R.string.msgmc);
        Toast.makeText(getApplicationContext(), sMsg, Toast.LENGTH_SHORT).show();
    }



    class OnClickListenerDept1 implements View.OnClickListener{
        //1. 이벤트 처리기 생성. 이름있는 클래스 생성 하는 첫번째 방법
        // 이벤트 처리기는 View.OnClickListener를 상속받으므로 재정의가 필요함
        // 재정의 필요함, 알트 엔터로 밑의것자동입력하기
        @Override
        public void onClick(View view) {
        // 클라우딩컴퓨터 텍스트뷰 클릭시 토스트 띄우기
            Toast.makeText(getApplicationContext(),R.string.mdept_name_c,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textViewMDQ);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD_ITALIC);
        // 텍스트뷰의 스타일 정하기.
        // 인자 1 : typeface, 인자2 : 설정할 것
        textViewDept1=findViewById(R.id.textViewMDCd);
        textViewDept2=findViewById(R.id.textViewMDQd);
        textViewTitle=findViewById(R.id.textViewTitle);
        imageViewDept1=findViewById(R.id.imageViewMDC);
        imageViewDept2=findViewById(R.id.imageViewMDQ);

        // 위에서 이름있는 클래스 생성 - 1(위에있음)
        //이름이 있는 클래스방법 : 이벤트 처리기 객체 생성 - 2
        OnClickListenerDept1 oclDept1= new OnClickListenerDept1();
        // 이름이 있는 클래스 방법 : 원하는 view에 이벤트 처리기를 등록
        textViewDept1.setOnClickListener(oclDept1);

        // 이름이 없는 클래스 첫번째 방법(익명 첫번째) : 클래스를 정의함과 동시에 객체를 생성해주기
        // 클래스 정의와 객체 생성을 동시에 하고
        View.OnClickListener oclDept2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          Toast.makeText(getApplicationContext(),R.string.dept_name_q,Toast.LENGTH_SHORT).show();
            }
        };
        // 생성된 처리기 객체를 등록해주기
        textViewDept2.setOnClickListener(oclDept2);

        // 이름이 없느 클래스 2번째 방법(익명 두번째)
        //클래스 정의, 객체 생성, 이벤트 처리 등록을 동시에 하기
        textViewDept2.setOnClickListener(new View.OnClickListener() {
            //여기가 클래스가 정의가 되는 곳 과    new로 객체가 생성이 되는 것과
            // textViewDept2.setOnClickListener 로 객체가 등록되는 것, 3가지가 동시에 일어남
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"실내건축 디자인과",Toast.LENGTH_SHORT).show();
            }
        });

        // 이벤트 처리기 .익명 두번째 방법, AlertDialog생성하기
        // 클래스 정의,. 객체 생성, 이벤트처리기 등록 동시에./
        textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String msg = getString(R.string.msg);
                AlertDialog.Builder adBuilder = new AlertDialog.Builder(MainActivity.this);
                                            // Activity내용이 들어가야함
                // 타이틀 설정
                adBuilder.setTitle("공지사항");
                // 메시지 설정
                adBuilder.setMessage(msg);

                // 다이얼로그에는 긍정 부정 중립 버튼이 3개있음 그중 긍정 버튼 .
                // 익명 두번째 방법 사용. - new DialogInterface.OnclickListener
                adBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // ok버튼 누르면 다이얼로그 창 닫기.
                        dialogInterface.dismiss();
                    }
                });
                adBuilder.show(); // 생성되면서 나타나게 됨.
            }
        });

        //익명 클래스 첫번째 방법 : 클래스 정의, 객체 생성을 동시에 하고 / 그 후에 처리기 등록하여 처리.
        // 이미지뷰 클릭시 스낵바 띄우기
        // 또한 스낵바 설정시 익명 두번째 방법
        // 이미지뷰 두개다 공유할수있는 그런 처리기.
        // 한개의 이벤트처리기를만들어 여러개에 적용할땐 이벤트 처리기 객세 생성한 후 하는게 좋아보임.
        View.OnClickListener oclImageListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.tel, Snackbar.LENGTH_LONG).
                        setAction("Ok", new View.OnClickListener() {
                             // Ok 누르면 또 클릭이벤트 생성                 // 또한 스낵바 설정시 익명 두번째 방법 - new View.OnClickListener()
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
                        // toast show
                    }
                }).show(); // Snackbar setAction을 보여줘야하는 show();
            }
        };
        // 처리기 등록하기
        imageViewDept1.setOnClickListener(oclImageListener);
        imageViewDept2.setOnClickListener(oclImageListener);
    }
}