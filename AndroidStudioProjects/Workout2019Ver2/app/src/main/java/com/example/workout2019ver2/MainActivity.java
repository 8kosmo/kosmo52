package com.example.workout2019ver2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //목록에서 운동제목 클릭하면 DetailActivity 호출하기
    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,(int)id);
        startActivity(intent);
    }
}
