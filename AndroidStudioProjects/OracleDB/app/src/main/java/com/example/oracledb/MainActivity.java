package com.example.oracledb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_login = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(btn_login==v){
            Log.d(this.getClass().getName(),"로그인호출");
            EditText et_id = findViewById(R.id.mem_id);
            String mem_id = et_id.getText().toString();
            EditText et_pw = findViewById(R.id.mem_pw);
            String mem_pw = et_pw.getText().toString();
            String result = null;
            try {
                LoginLogic loginLogic = new LoginLogic();
                result =
                        loginLogic.execute(mem_id,mem_pw).get();
                Log.d(this.getClass().getName(),"result="+result);
            }catch (Exception e){
                Log.d(this.getClass().getName(),"exception:"+e.toString());
            }
        }
    }
}
