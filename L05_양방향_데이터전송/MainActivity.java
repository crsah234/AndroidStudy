package com.example.a05_activity2;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editSNo, editPwd;

    // 콘트랙트 개체 생성 <I,O>
    ActivityResultContract<Intent, ActivityResult> contract
            = new ActivityResultContracts.StartActivityForResult();
    // 콜백개체생성<O>
    ActivityResultCallback<ActivityResult> callback= new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            //  certActivity엣 finish 누르고 넘어오는곳ㅇ ㅣ여기임.
            int resultCode = result.getResultCode();
            if(resultCode == RESULT_OK){
                // 인텐트 추출
                Intent data = result.getData();
                //type 넘어온값 받기
                String stype=data.getStringExtra("type");
                //alertdiaol 생성자이용해서 만들기.
                AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
                // 어떤증명서인지 제목으로 만들기
                aBuilder.setTitle(stype);
                aBuilder.setMessage(getString(R.string.result));

                // 버튼 만들기 ok버튼
                //2번째 매개변수에서 이벤트 처리기 생성해주기. 동시에 클래스도 정의해줘야함
                // 2번째 매개변수 : new DialogInterface.OnClickListener()
                aBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog가 닫힐수 있도록.
                        dialog.dismiss();
                    }
                });
                //다이얼로그 생성해서 띄우기.
                aBuilder.show();
            } else {
                Toast.makeText(MainActivity.this,"취소되었습니다",Toast.LENGTH_SHORT).show();
            }
        }
    };


    // resultlauncher(<I>
    ActivityResultLauncher<Intent> resultLauncher; //생성은 온크리에이트 메소드안에서할것임
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSNo=findViewById(R.id.editTextSNo);
        editPwd=findViewById(R.id.editTextPassword);

        resultLauncher=registerForActivityResult(contract, callback);
        // registerForActivityResult 안에 매개변수? 두개 알아보기.
        Button btnLogin=findViewById(R.id.buttonLogin);
        // 생성과 동시에 클래스 생성하기
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //학번과 학번정보 읽어오기 - string 타입으로
                String sno =editSNo.getText().toString().trim();// 공백도 없애기.
                String spwd =editPwd.getText().toString().trim();// 공백도 없애기.

                //2개다, 아이디? 비번 둘다 입력되어야 넘어갈수잇게끔해야함 현재는 비어있는지만 체크하기
                if(sno.isEmpty()||spwd.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "학번과 비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show();
                    return; //비어있으면 그냥 리턴하는 방법도있으나 치친절하게 알려주기
                }
                //학번 비번 둘다 빈값이 아닐경우 넘어가게하기
                Intent intentS = new Intent(getApplicationContext(),CertActivity.class);
                intentS.putExtra("sno",sno);
                intentS.putExtra("pwd",spwd);
                resultLauncher.launch(intentS);
                //제어가  안드로이드에 이ㅡ해 certActiity  oncreate 함수가 호출이됨
                //getApplicationContext()로 해도되고 acitivyt this?로해도되나모르겟다
            }


        });
    }
}