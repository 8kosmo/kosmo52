package com.example.pizza2019ver2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {
    private static final String TAG = "OrderActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //액션바 유형 객체 반환하고 파라미터는 true
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
/*
    Toast사용해서 메시지를 짧게 혹은 길게 처리하듯이
    Snackba를 이용해서 메시지 처리가 가능함.
    차이점:사용자와 상호작용이 가능함.
 */
    public void orderAdd(View view){
        //FAB을 클릭하면 실행되는 코드 추가하기
        Log.v(TAG,"주문하기 호출");
        CharSequence msg = "나는 스낵바.....";
        int duration = Snackbar.LENGTH_SHORT;
        //첫째-스낵바를 표시할 뷰
        //두번째-메시지
        //세번째-시간
        Snackbar snackbar =
                Snackbar.make(findViewById(R.id.coordinator)
                              ,msg
                              ,duration);
        snackbar.setAction("Undo",new View.OnClickListener(){
            public void onClick(View view){
                Toast toast = Toast.makeText(OrderActivity.this
                                           , "Undone"
                                           ,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        //스낵바 표시 메소드 호출
        snackbar.show();
    }
}
