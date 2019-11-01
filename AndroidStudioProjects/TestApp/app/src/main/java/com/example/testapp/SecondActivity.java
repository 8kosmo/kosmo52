package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.widget.CompoundButton.*;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_second2);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        Button btn_send = new Button(this);
        btn_send.setText("전송");
        ll.addView(btn_send);
        TextView tv_msg = new TextView(this);
        tv_msg.setText("안녕하세요");
        ll.addView(tv_msg);
        setContentView(ll);
    }
}
