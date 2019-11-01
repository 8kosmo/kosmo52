package com.example.membermanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.List;

public class MemberListActivity extends AppCompatActivity {
    SQLiteDatabase db = null;
    Cursor cursor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        ListView lv_member = findViewById(R.id.lv_member);
        DBHelper dbHelper = new DBHelper(this);
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.query("tb_member", new String[]{"_id", "mem_name"}, null, null, null, null, null);
            String[] from = {"_id", "mem_name"};
            int[] to = {android.R.id.text1, android.R.id.text2};
            SimpleCursorAdapter adapter =
                    new SimpleCursorAdapter(
                            this, android.R.layout.simple_list_item_2, cursor, from, to, 0);
            lv_member.setAdapter(adapter);
        }catch(SQLiteException se){
            Log.d(this.getClass().getName(),"exception:"+se.toString());
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
