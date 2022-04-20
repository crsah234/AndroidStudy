package com.example.a07e_navigationdrawer;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a07e_navigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // manifest을 보면 노액션바로 되어잇기에 명시적으로 쓰게함
        setSupportActionBar(binding.appBarMain.toolbar);
        //플로팅 액션 버튼
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setOpenableLayout(drawer)
                .build();*/
        // 가변 길이 메소드, 최상위 메뉴들 넣는것. 수업에서 아이디 하나 삭제함.
        // 위에 . . . 으로 이으는게 메소드 채인.

        AppBarConfiguration.Builder adbuilder = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.infoFragment,R.id.introFragment1,R.id.introFragment2);
        adbuilder.setOpenableLayout(drawer);
        mAppBarConfiguration = adbuilder.build();
        // 위에 주석친것과 같은 것임 여기아이디가 들어있는것들은 삼단줄 메뉴 로 들어오게됨/ 그 최상위메뉴들
        // 여기 없는 것은 <- 표시가 나오게됨. (메뉴에서 클릭하여 화면이 바뀐후)
        // 아이디 값은 activity_main_drawer이ㅡ 아이디 == mobile_navigation.xlm의 아이디값과 같다.

        //나브컨트롤러 객체 생성
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //나브컨트롤러와 연동
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        // navigationview 와 나브컨트롤러 연동
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}