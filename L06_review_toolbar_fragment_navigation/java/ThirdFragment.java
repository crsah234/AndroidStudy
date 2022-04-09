package com.example.a06_toolbar_navigation_220408;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "type";

    // TODO: Rename and change types of parameters
    // 안드로이드가 스스로 만들어 놓아 넘어온값을 받아오게끔 만든것.
    private String mParam1;


    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    // 역할은 thirdfragment 객체 생성, 돌려주는  역할 - > 간단히 생성ㅎ는 역할을 함.
    public static ThirdFragment newInstance(String param1) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // 넘어온값을 받아줌.
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.textViewResult);
        String sresult = getString(R.string.result);
        //증명서 정보와 sresult 같이보여줌
        textView.setText(mParam1 + "\n"+sresult);

        // thirdfragment->firstfragment 로 넘어가는것 제작
        Button btnToMain = view.findViewById(R.id.buttonToMain);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fragment아이디(네비게이션 그래프에 정의된 아이디)도 넣어줌줌
                NavHostFragment.findNavController(ThirdFragment.this).popBackStack(R.id.FirstFragment,false);
            }
        });

        // 백버튼 눌렀을때
        // dispatcher 객체의 역할은 명시적으로 백버튼 클릭될시 이벤트를 처리하는애로 넘겨주는 역할
        // 이벤트처리기등록하는게 addCallBack함수
        //
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavHostFragment.findNavController(ThirdFragment.this).popBackStack(R.id.FirstFragment, false);
            }
        });
    } //onViewCreated 끝 부분
}