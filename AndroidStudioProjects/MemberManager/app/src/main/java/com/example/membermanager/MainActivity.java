package com.example.membermanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id, et_pw, et_name = null;
    Button btnAdd = null;
    Button btnUpd = null;
    Button btnDel = null;
    Button btnSel = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpd = findViewById(R.id.btnUpd);
        btnDel = findViewById(R.id.btnDel);
        btnSel = findViewById(R.id.btnSel);
        btnAdd.setOnClickListener(this);
        btnUpd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnSel.setOnClickListener(this);
    }//end of onCreate
    public void onClick(View v){
        Log.d(this.getClass().getName(),"onClick호출:"+v.findViewById(R.id.btnAdd));
        if(v.findViewById(R.id.btnAdd)==btnAdd){//입력일 경우 - 입력처리된 후 조회 화면 호출
            String mem_id = et_id.getText().toString();
            String mem_pw = et_pw.getText().toString();
            String mem_name = et_name.getText().toString();
            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("insert into tb_member(mem_id,mem_pw,mem_name) values(?,?,?);",new String[]{mem_id, mem_pw, mem_name});
            db.close();
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);

        }else if(v.findViewById(R.id.btnUpd)==btnUpd){

        }else if(v.findViewById(R.id.btnDel)==btnDel){

        }else if(v.findViewById(R.id.btnSel)==btnSel){
            Intent intent = new Intent(this,MemberListActivity.class);
            startActivity(intent);
        }
    }//end of onClick
}
