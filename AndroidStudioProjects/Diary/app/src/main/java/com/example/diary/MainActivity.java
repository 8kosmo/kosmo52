package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatePicker dp_diary = null;
    EditText et_diary = null;
    Button btn_save = null;
    //그날 작성한 일기장의 파일 명
    String fileName = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //아래 메소드 호출하면 기본 창이 구성완료
        setContentView(R.layout.activity_main);
        //구성이 완료된 후(DOM구성이 끝나면) 객체 접근이 가능/변경
        dp_diary = findViewById(R.id.dp_diary);
        et_diary = findViewById(R.id.et_diary);
        btn_save = findViewById(R.id.btn_save);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        //날짜 정보가 변하면 파일명도 변경처리
        dp_diary.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year)
                        +"_"+Integer.toString(monthOfYear+1)
                        +"_"+Integer.toString(dayOfMonth)+".txt";
                String str = readDiary(fileName);
                btn_save.setEnabled(true);
            }
        });//익명클래스로 처리하기
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String msg = et_diary.getText().toString();
                    fos.write(msg.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),fileName+"이 저장됨",Toast.LENGTH_LONG).show();
                }catch(IOException ie){
                    Log.d(this.getClass().getName(),""+ie.toString());
                }
            }
        });
    }
    /*
    파일 이름을 파라미터로 받는다.
    읽어온 일기를 저장할 변수
    현재 읽어온 일기이면 버튼은 수정하기 버튼으로 라벨 변경처리
     */
    public String readDiary(String fileName){
        String diary = null;
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);
            byte txt[] = new byte[100];
            fis.read(txt);
            fis.close();
            diary = new String(txt);
            btn_save.setText("수정하기");
        }catch(IOException ie){
            et_diary.setHint(fileName+" 일기 없음");
            Log.d(this.getClass().getName()
                     ,"exception:"+ie.toString());
            btn_save.setText("새로저장");
        }
        return diary;
    }

}
