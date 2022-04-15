package com.example.a05_activity2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cert);
        Intent intentR = getIntent();
        //넘어온 데이터 받아서 표시까지하기.
        if(intentR !=null){
            TextView textView = findViewById(R.id.textViewSNo);
            String sno = intentR.getStringExtra("sno");
            textView.setText("로그인 : "+sno);
        }

        //증명서 눌렀을때 화면 이동하기
        View.OnClickListener ocl= new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 텍스트뷰 값 가져오는것임. View v가말이야.
                //클릭한 텍스트뷰 그 자체임
                //String stype = v.getText.toString(); gettext에서 오류남 - textview에서만 쓸수잇는기능이기ㄸ문. 명
                // 명시적형변환이 필요함
                String stype = ((TextView)v).getText().toString();
                Intent intent = new Intent();
                intent.putExtra("type",stype);
                setResult(RESULT_OK,intent);
                finish(); // certacivity를 완전히 끝내고 넘어갈때 finish, startActivity는 안끝낸고넘어감
            }
        };

        //ocl 만든거 3개 텍뷰에다가 공유하게끔 뿌려줌
        TextView cert1 = findViewById(R.id.textViewCert1);
        TextView cert2 = findViewById(R.id.textViewCert2);
        TextView cert3 = findViewById(R.id.textViewCert3);

        cert1.setOnClickListener(ocl); // ocl객체 넘겨줌
        cert2.setOnClickListener(ocl);
        cert3.setOnClickListener(ocl);
    } //oncreate


    // 최소눌렀을때 다시 돌아가기 만들기
    public void onClickToMain(View view) {
        //setResult(RESULT_CANCELED); //취소한거니 데이터가없어 두번째매개벼ㅛㄴ수없음
        finish(); // 의미없는 데이터 감. finishi만해도  result_Canceled로 값이 넘어가므로 피니시만해도됨
    }
}