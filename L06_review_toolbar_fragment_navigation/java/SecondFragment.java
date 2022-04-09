package com.example.a06_toolbar_navigation_220408;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a06_toolbar_navigation_220408.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //로그인 하고 학번을 위에띄우기
        Bundle bundle = getArguments();
        if(bundle!=null){
            String sno = bundle.getString("sno");
            binding.textViewSNo.setText("로그인: "+sno);

        }

        /*binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });*/
        // 로그인화면으로넘어가는 버튼(메인화면으로)
        binding.buttonCertToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popbackstack 실행
                NavHostFragment.findNavController(SecondFragment.this).popBackStack();
            }
        });
        //cert1
        //증명서 클릭시 화면넘어가는것
        binding.textViewCert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //증명서의 종류 넘기기. -> 두번째 프래그먼트에서 세번째 프래그먼트로 넘기는 것.
                String stype = ((TextView)v).getText().toString();
                //bundle 객체로 넘기기
                Bundle bundle = new Bundle();
                bundle.putString("type",stype);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment,bundle);
            }
        });
        //cert2
        binding.textViewCert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //증명서의 종류 넘기기. -> 두번째 프래그먼트에서 세번째 프래그먼트로 넘기는 것.
                String stype = ((TextView)v).getText().toString();
                //bundle 객체로 넘기기
                Bundle bundle = new Bundle();
                bundle.putString("type",stype);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment,bundle);
            }
        });
        // 졸업증명서 넘기는것 과제
        binding.textViewCert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stype = ((TextView)v).getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("type",stype);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment,bundle);
            }
        });

        // popbackstack 메소드 호출, 매개변수 넘겨주기 / 세컨드 밑에있는 퍼스트로 넘어가기에 매개변수없어도됨. 매ㅐㄱ변수에는 넘어갈 그 navgraph아이디가들어가기ㄸ문
        binding.buttonCertToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기서는 세컨드 바로밑에있는것이 퍼스트이기때문에 매개변수로 안념겨줘도 값이 넘어갑니다.

                NavHostFragment.findNavController(SecondFragment.this).popBackStack();
            }
        });
    } // onViewCreated 끝부분

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}