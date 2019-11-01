package com.example.chap07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Fragment fragment = new TopFragment();
        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frag_top,fragment);
        ft.commit();
    }
}
