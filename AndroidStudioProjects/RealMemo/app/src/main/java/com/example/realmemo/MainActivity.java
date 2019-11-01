package com.example.realmemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    EditText et_title = null;
    EditText et_content = null;
    Button btn_add = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        final String u_title = et_title.getText().toString();
        final String u_content = et_content.getText().toString();
        Realm.init(this);
        Realm rm = Realm.getDefaultInstance();
        rm.executeTransaction(new Realm .Transaction(){
            @Override
            public void execute(Realm realm) {
                MemoVO mvo = realm.createObject(MemoVO.class);
                mvo.title = u_title;
                mvo.content = u_content;
            }
        });
        //등록된 메모를 확인하는 페이지 호출하기
        Intent intent = new Intent(this,MemoReadActivity.class);
        intent.putExtra("title",u_title);
        startActivity(intent);
    }
}
