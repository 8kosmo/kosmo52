package com.example.beer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FindBeerActivity extends AppCompatActivity {
    TextView tv_msg = null;
    TextView tv_name = null;
    Button btn_send = null;
    class InnerEventHandler implements View.OnClickListener{
        public void onClick(View v){
            Toast.makeText
                    (getApplicationContext(),"버튼클릭",Toast.LENGTH_LONG).show();
            tv_name.setText("강감찬");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        tv_name = findViewById(R.id.tv_name);
        btn_send = findViewById(R.id.button);
        //tv_name.setText("이순신");
        tv_msg = findViewById(R.id.tv_msg);
        tv_msg.setText("안녕하세요.");
        //InnerEventHandler myHandler = new InnerEventHandler();
        //btn_send.setOnClickListener(myHandler);
        MyEventHandler myHandler = new MyEventHandler(tv_name, tv_msg);
        btn_send.setOnClickListener(myHandler);
    }
    public void onSend(View view){
        //Toast.makeText(getApplicationContext(),"버튼클릭",Toast.LENGTH_LONG).show();
        //MyEventHandler myHandler = new MyEventHandler(tv_msg);
       // btn_send.setOnClickListener(myHandler);

        tv_msg.setText("수고했어요.");
    }
}
