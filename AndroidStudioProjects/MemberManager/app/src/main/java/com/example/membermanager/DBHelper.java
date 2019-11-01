package com.example.membermanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
사용자가 처음 앱을 설치하는 상황
1.사용자가 앱을 처음 설치하면 데이터베이스가 존재하지 않으므로
  SQLite 헬퍼가 데이터베이스 생성함.
  XXX.db
2.데이터베이스가 생성되면 SQLite헬퍼의 onCreate호출

기존 사용자가 앱을 설치하는 상황
1.사용자가 새버전의 앱을 설치하면 SQLite헬퍼는 기존에 데이터
베이스가 존재하는지 확인
2.새로 생성된 SQLite헬퍼의 버전과 기존 데이터베이스 버전 숫자를
비교함.
:새버전의 숫자가 더 높으면 onUpgrade메소드를 실행해서
버전숫자를 갱신함.

 */
public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 4;
    public DBHelper(Context context){
        super(context
                , "scott.db"
                ,null
                ,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String memberSQL = "create table tb_member("+
                "_id integer primary key autoincrement,"+
                "mem_id text,"+
                "mem_pw text,"+
                "mem_name text);";
        db.execSQL(memberSQL);
    }
/*
유효하지 않은 사용자의 데이터베이스 버전
SQLite에 설정된 새버전

 */
    @Override
    public void onUpgrade(SQLiteDatabase db
                        , int oldVersion
                        , int newVersion) {
        if(newVersion==3){
            db.execSQL("drop table tb_member");
            onCreate(db);
        }
    }
}
