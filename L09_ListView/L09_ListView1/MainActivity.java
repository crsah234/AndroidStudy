package com.example.a09e_listview1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a09e_listview1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        bind= ActivityMainBinding.inflate(getLayoutInflater());
        //레잉아웃 인플레이션발생 및 액티비티메인바인딩 객체 생성?
        setContentView(bind.getRoot());
        //첫번쨰리스트뷰 , 항목을 눌를때마다 토스트기 띄
        bind.listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // adapterview 보고있는 뷰 자체
                // view는 클릭한 항목, 그 개체
                // i는 클릭한 항목이 몇번째 항목인지 알려주는 매개변수
                // l은 어답터가 각항목의 아이디를관리가능한데, 그 아이디값을 넘겨받음
                String sText= ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(),sText,Toast.LENGTH_SHORT).show();
            }
        });

        // 함수 밖에 것.
        // 1. ListView에서 보여줄 데이터를 저장할 arraylist 생성
        ArrayList<String> listData2 = new ArrayList<String>();
        // 2. android.R.layout.simple_list_item_single_choice 안드로이드가붙은이유는 안드에서 미리만들어놓은것임
        //  context, 각 항목을 보여줄 layout, ListView에서 보여줄 데이터를 저장하고 있는 객체
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice,listData2);
        // this에서 데이터뽑아 listData2로 가져오는듯

        // 3. ListView에 adapter를 설정함
        bind.listView2.setAdapter(arrayAdapter);

        // 4. 항목 추가
        arrayAdapter.add("list2 item1");
        arrayAdapter.add("list2 item2");
        arrayAdapter.add("list2 item3");
        arrayAdapter.add("list2 item4");
        arrayAdapter.add("list2 item5");
        arrayAdapter.add("list2 item6");
        arrayAdapter.add("list2 item7");
        arrayAdapter.add("list2 item8");
        arrayAdapter.add("list2 item9");
        arrayAdapter.add("list2 item10");
        arrayAdapter.add("list2 item11");

        // 5. 항목 삭제
        arrayAdapter.remove("list2 item4"); // list2 item4 삭제하는것제

        // 6. 항목 수정
        listData2.set(0,"list item1111");//0은 첫번쨰 항목 수정하는것정

        // 7. 항목이 변경되었음을 알려줌
        arrayAdapter.notifyDataSetChanged(); // 호출해야 변경한게 반영이된다!!!




        //hashmap<key,value>
        // 1. ListView에 보여줄데이터를 저장할 ArrayList 생성
        ArrayList<HashMap<String,String>> listData3 = new ArrayList<>();

        // 2. simpleadapater 객체 생성하기
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listData3,
                android.R.layout.simple_list_item_activated_2,
                new String[]{"schedule","date"},new int[]{android.R.id.text1,android.R.id.text2});
                //simple어답터랑 어레이어답터 매개변수차이 알기!
                //this는 메인레이아웃,
        // string [] 은 초기값 넣어주기, 어떤이름으로 데이터 끄집어낼거냐 - 이름쓰기
        //new String[]{"schedule","data" 라는 이름으로 저장해서가져오고,
        // schedule - text1, data-text2 연결됨.
        //simple_list_item_activated_2, 에 있는 text1, text2임.

        // 4 사용할 어답터 객체 연결시켜주기.
        bind.listView3.setAdapter(simpleAdapter);

        //해시맵 객체 생성
        HashMap<String,String> hitem = new HashMap<>();
        // 아이템넣기
        hitem.put("schedule","내생일");
        hitem.put("date","5/5");
        listData3.add(hitem); // 위의 2개 추가하는것임.

        //아이템 넣고 초기화
        hitem = new HashMap<>();
        hitem.put("schedule","친구생일");
        hitem.put("date","5/15");
        listData3.add(hitem);

        hitem = new HashMap<>();
        hitem.put("schedule","어버이날");
        hitem.put("date","5/8");
        listData3.add(hitem);

        hitem = new HashMap<>();
        hitem.put("schedule","기말고사");
        hitem.put("date","6/8");
        listData3.add(hitem);
        //꼭불러주기 simpeadapter.notifysetchanged
        simpleAdapter.notifyDataSetChanged();
    }//oncreate
}