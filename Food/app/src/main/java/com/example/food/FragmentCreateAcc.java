package com.example.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCreateAcc extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity.titleBar.setText("Реєстрація");
        return inflater.inflate(R.layout.fragment_create_account,container,false);
    }

    public void onResume(){
        super.onResume();
        MainActivity.titleBar.setText("Реєстрація");
    }

}
