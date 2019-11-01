package com.example.realmemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;

public class MemoReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_read);
        TextView tv_title = findViewById(R.id.tv_title);
        TextView tv_content = findViewById(R.id.tv_content);
        //MainActivity에서 intent로 넘긴 메시지 읽기
        Intent intent = getIntent();
        String mtitle = intent.getStringExtra("title");
        Realm rm = Realm.getDefaultInstance();
        MemoVO mvo =
                rm.where(MemoVO.class)
                        .equalTo("title",mtitle)
                        .findFirst();
        tv_title.setText(mvo.title);
        tv_content.setText(mvo.content);
    }
}
