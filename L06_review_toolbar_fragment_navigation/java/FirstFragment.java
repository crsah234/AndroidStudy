package com.example.a06_toolbar_navigation_220408;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a06_toolbar_navigation_220408.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/

        // 로그인 버튼
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. navcontroller 객체얻어오기
                NavController navController = NavHostFragment.findNavController(FirstFragment.this);
                // 학번등을 가져오는것을 생성 - 텍스트가져와서 string 타입, 공백 삭제
                // binding.객체를 이용하여 값을 가져옴
                String sno = binding.editTextSNo.getText().toString().trim();
                String spwd = binding.editTextPassword.getText().toString().trim();

                // 빈 값이 아닐경우에만 실행
                if(sno.isEmpty()||spwd.isEmpty()){
                    Toast.makeText(getContext(), "아이디와 비번을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return ; // 리턴을주어 다음 코드 실행못하게함.
                }
                Bundle bundle = new Bundle();
                bundle.putString("sno",sno);
                bundle.putString("spwd",spwd);
                // 어디에서 어디로 이동할거냐! , 번들을 넣어주어야 값이 넘어감.
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);

            }
        });
    }  // onViewCreated 끝 부분

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
