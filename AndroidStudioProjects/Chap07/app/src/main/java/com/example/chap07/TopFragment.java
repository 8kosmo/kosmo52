package com.example.chap07;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {


    public TopFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
            Fragment fragment = new SecondFragment();
            FragmentTransaction ft =
                    getChildFragmentManager().beginTransaction();
            ft.add(R.id.frag_second,fragment);
            //SecondFragment를 추가하고 트랜잭션을 백스택에 추가
            ft.addToBackStack(null);
            //프래그먼트를 바꿀 때 희미해지고 또렷해지는 효과주기
            ft.setTransition
                    (FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

}
