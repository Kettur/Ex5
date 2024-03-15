package com.example.ex5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex5.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());

        binding.buttonTo2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("dataFromMain", binding.textTo2nd.getText().toString());
                Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
            }
        });
        binding.buttonTo3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("dataFromMain", binding.textTo3rd.getText().toString());

                Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_thirdFragment, bundle);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){
            String data2nd = bundle.getString("dataFrom2nd");
            if (data2nd != null){
                binding.textFrom2nd.setText("Data from 2nd: " + data2nd);
            }
            String data3rd = bundle.getString("dataFrom3rd");
            if (data3rd != null){
                binding.textFrom3rd.setText("Data from 3rd: " + data3rd);
            }
        }
    }
}