package com.example.workout2019ver2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment frag =
                (WorkoutDetailFragment)
                        getSupportFragmentManager()
                                .findFragmentById(R.id.detail_frag);
        //아래코드는 운동 Id값을 하드코딩한것이므로 삭제처리
        //frag.setWorkoutId(2);
        //아래는 위에서 상수로 처리한 것과는 달리 인텐트를 통해서 전송된 값을 꺼내서
        //초기화하는 코드임.
        int workoutId = (int)getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        frag.setWorkoutId(workoutId);//0 or 1 or 2 or 3
    }
}
