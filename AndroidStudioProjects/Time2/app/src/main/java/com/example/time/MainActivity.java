package com.example.time;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/*
문제 제기
1초동안 지연 후 코드를 반복적으로 재실행시켜야 함.
일정한 시점에 수행하도록 제어하는 클래스가 필요함.
Handler클래스를 사용하면 특정 코드를 미래 특정한 시점에 수행 가능함.
메인 안드로이드 스레드가 아닌 다른 스레드 코드를 실행할 때도 사용가능.

구현방법
실행을 계획할 코드를 Runnable객체로 재정의 하고
Handler의 post메소드와 postDelayed메소드로 언제 코드를
실행할지 지정가능함.
post메소드 - 거의 즉시 실행할 때 사용함.

final Handler handler = new Handler();
handler.post(Runnable);

postDelayed()
미래에 실행할 수 있다.
파라미터는 Runnable과 int를 받음.
 */
public class MainActivity extends Activity {
    //지금까지 흐른 시간을 담을 변수 선언
    int seconds = 0;
    //스톱워치가 실행중인지 저장하는 변수
    //stop를 누르면 false를 저장하고 start이면 true저장하고
    //리셋을 누르면 둘 다 값을 변경해야 함.
    //어떻게 바꿔야 하지?????

    boolean running;
    //나 실행중이었니? 응 or 아니
    boolean wasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액티비티가 생성 되면 이 메소드 호출함.
        //주의할 점:반드시 runTime호출전에 가져올것.
        if(savedInstanceState!=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTime();
    }
    //onStop메소드가 호출되기 직전에 실행되어야 함.-콜백메소드
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        //액티비티가 다시 생성되면(세로본능) wasRunning변수의
        //상태를 다시 복원 -> 기억
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }
    public void onStop(){
        super.onStop();
        //onStop이 호출되었을 때 스톱워치가 실행중이었는지 저장함.
        wasRunning = running;
        running = false;
    }
    public void onStart(){
        super.onStart();
        if(wasRunning){
//이전에 실행된 기억을 가지고 있다면 running변수의 true로 설정을 변경
//원래는 false였던 것을 true변경
//true로 runTime메소드에서는 뭘하는거지?
            running =true;
        }
    }
    //타이머 구현 메소드 선언
    /*
    1초동안 지연하고 주기적으로 코드를 실행시킴
    실행될 때마다 seconds 값을 증가시킴
    텍스트뷰를 갱신처리하기
     */
    public void runTime(){
        //화면을 구성하는 xml로 부터 TextView를 가져오기
        final TextView tv_time = findViewById(R.id.tv_time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time =
                        String.format(Locale.getDefault()
                                     ,"%d:%02d:%02d"
                                     , hours,minutes,secs);
                //화면에 시간 정보 갱신하기
                tv_time.setText(time);
                //초정보 언제 1씩 증가해주면 될까?
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    public void timeStart(View v){
        running = true;
    }
    public void timeStop(View v){
        running = false;
    }
    public void timeReset(View v){
        running = false;
        seconds = 0;
    }
}
