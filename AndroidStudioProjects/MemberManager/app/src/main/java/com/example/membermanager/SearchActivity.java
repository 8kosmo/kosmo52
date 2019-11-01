package com.example.membermanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    Cursor cursor = null;
    SQLiteDatabase db = null;
    MemberAdapter memberAdapter = null;
    ArrayList<MemberVO> memList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        DBHelper dbHelper = new DBHelper(this);
        ListView lv_member = findViewById(R.id.list_member);
        memList = new ArrayList<>();
        try {
            db = dbHelper.getWritableDatabase();
            cursor = db.rawQuery("SELECT _id, mem_id,mem_pw, mem_name FROM tb_member;", null);
    //db에서 커낸 값을 담기
            while(cursor.moveToNext()){
                memList.add(new MemberVO(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            }
            memberAdapter = new MemberAdapter(SearchActivity.this,memList);
            lv_member.setAdapter(memberAdapter);
        }catch (SQLiteException se){
            Log.d(this.getClass().getName(),"exception:"+se.getMessage());
        }
    }
    //사용한 자원 반납하기
    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
