package com.example.workout2019ver2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class WorkoutDetailFragment extends Fragment {
    private long workoutId;
    public void setWorkoutId(long workoutId){
        this.workoutId = workoutId;
    }
    public WorkoutDetailFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }
    //프래그먼트가 보이는 상태가 되기 바로 직전에 호출
    public void onStart(){
        //생명주기에 대한 콜백메소드 구현시 반드시
        //상위 콜백메소드를 호출할것.
        super.onStart();
        //Fragment는 Context를 갖지 못하므로 단독으로
        //R.java를 접근불가하다.
        View view = getView();
        if(view!=null){
            TextView tv_title = view.findViewById(R.id.textTitle);
            //선택한 운동제목에 대응하는 아이디 상수값에 해당하는 배열접근
            Workout workout =
                    Workout.workouts[(int)workoutId];
            tv_title.setText(workout.getName());
            TextView tv_description =
                    view.findViewById(R.id.textDescription);
            tv_description.setText(workout.getDescription());
        }

    }
}
