package com.example.a06_toolbar_navigation_220408;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a06_toolbar_navigation_220408.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    // View binding 알아보기. 밑에가 그 객체임/ 화면구성요소에 직접적으로 접근 가능.
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 인플레이션 == setContentView
        // baisc activity에서 화면구성하는 곳
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 매인 레이아웃에 작성한 툴바를 액션바로서 사용하라고 알려줌.
        // binding.id. findVIewById안해도 객체에 접근 가능한것을 뷰 바인딩이라고함.
        //id값에는 id로 저장된것만사용가능.
        setSupportActionBar(binding.toolbar);

        //네비게이션 관련된것.
        // navController의 역할 : 프래그먼트 이동 하는데 필요한 컨트롤러 인듯?
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //floationg 액션? 옵션 ? 을 클릭시 작동하는 곳.
        // basic activity에는 우측하단에 동그라미 +버튼 나옴.
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 지난시간의 전화걸기 복습하기.
                Snackbar.make(view, "전화걸기", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //ACTION_DIAL 쓰는게 좋음 - 이유 와이? 전화화면띄울때 상대적으로 더 좋다?
                                //parse에 빈칸있으면 안됨.
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01067114740"));
                                startActivity(intent);
                            }
                        }).show();
            }
        });
    }// OnCreate

    // 메뉴를 생성해주는 역할. 자동으로 호출이 되는 것/ 명시적이 아님.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 호출하는 순간 메뉴 인플레이터객체가 메뉴레이아웃읽어서 메뉴 생성?함.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // 메뉴 다 구성됬다는 의미로 true 반환함.
        return true;
    }

    // 각각의 메뉴항목이 클릭될때 호출되는 것.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection Simplifiable If Statement - ?
        if (id == R.id.action_home) {
            // 동미대 홈페이지로 이동
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dongyang.ac.kr"));
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_location){
            // 암시적 인텐트를 통해 지도를 보여줌 - 과제.
            Uri uri = Uri.parse("geo:37.50014293285583, 126.86787227062011");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}