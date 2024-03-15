package com.example.ex5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex5.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThirdBinding binding = FragmentThirdBinding.inflate(getLayoutInflater());

        String data = getArguments().getString("dataFromMain");
        binding.textFromMain.setText("Message from Main: " + data);


        binding.buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFrom3rd", binding.textToMain.getText().toString());


                Navigation.findNavController(v).navigate(R.id.action_thirdFragment_to_firstFragment, bundle);
            }
        });
        return binding.getRoot();
    }
}