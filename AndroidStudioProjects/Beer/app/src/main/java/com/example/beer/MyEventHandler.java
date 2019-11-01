package com.example.beer;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyEventHandler implements View.OnClickListener {
    TextView tv_name = null;
    TextView tv_msg = null;
    public MyEventHandler(TextView tv_name){
        this.tv_name = tv_name;
    }
    public MyEventHandler(TextView tv_name, TextView tv_msg){
        this.tv_name = tv_name;
        this.tv_msg = tv_msg;
    }
    @Override
    public void onClick(View v){
        tv_name.setText("김유신");
        tv_msg.setText("오늘 8시 스터디 어때?");
    }
}
