package com.example.filebasic;

import android.content.Context;
import android.widget.LinearLayout;
/*
   xml -> java변환 inflate()
   상속이나 라이프사이클 메소드 사용시에는
   반드시 상위 메소드를 호출할 것.
   ==> 상위클래스의 생성자 호출
   생성자 호출이 먼저 된 후에야 콜백메소드사용가능
 */
public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        super(context);
    }
}
