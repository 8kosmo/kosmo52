package com.example.filebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_write = null;
    Button btn_read = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_write = findViewById(R.id.btn_write);
        btn_read = findViewById(R.id.btn_read);
        btn_write.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(btn_write==v){
            Log.d(this.getClass().getName(),"쓰기");
            try {
                FileOutputStream fos =
                        openFileOutput("file.txt"
                                     , Context.MODE_PRIVATE);
                String msg = "MODE_PRIVATE-생성된 파일은 호출된 응용프로그램만 접근가능함.";
                fos.write(msg.getBytes());
                fos.close();
                Toast.makeText(getApplicationContext()
                              ,"file.txt파일 생성"
                              ,Toast.LENGTH_LONG).show();
            }catch (IOException ie){
                Log.d(this.getClass().getName(),ie.toString());
            }
        }
        else if(btn_read==v){
            Log.d(this.getClass().getName(),"읽기");
            try {
                //파일이름을 객체화 해서 메모리 로딩
                FileInputStream fis =
                        openFileInput("file.txt");
                byte[] txt = new byte[100];
                fis.read(txt);
                String temp = new String(txt);
                TextView tv_read = findViewById(R.id.tv_read);
                tv_read.setText(temp);
            }catch (IOException ie){
                Log.d(this.getClass().getName(),ie.toString());
            }
        }
    }
}
