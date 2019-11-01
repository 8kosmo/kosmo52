package com.example.membermanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
문제제기
ListView에는 한번에 하나의 컬럼만 로우는 여러개 출력할 수 있다.

 */
public class MemberAdapter extends BaseAdapter {
    //화면을 처리하는데 있어서 Activity에 접근해야 하므로
    //이 주소번지를 참조할 변수필요
    Context context = null;
    ArrayList<MemberVO> memList = null;
    MemberVO mVO = null;
    TextView tv_id, tv_mid, tv_pw, tv_name = null;
    public MemberAdapter(Context context, ArrayList<MemberVO> memList){
        this.context = context;
        this.memList = memList;
    }
    @Override
    public int getCount() {
        return memList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.memList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            /*
            SearchActivity가 갖는 View영역을 사용하기 위해서 선언하였다.
            member.xml에 선언된 화면 컴퍼넌트를 java코드에서 사용할 수
            있도록 변환작업이 필요함. -inflate메소드를 호출한 이유
             */
            convertView =
                    LayoutInflater.from(context).inflate
                            (R.layout.member,null);
            tv_id = convertView.findViewById(R.id.tv_id);
            tv_mid = convertView.findViewById(R.id.tv_mid);
            tv_pw = convertView.findViewById(R.id.tv_pw);
            tv_name = convertView.findViewById(R.id.tv_name);
            //그 컴포넌트에 읽어온 값을 출력함.
            tv_id.setText(String.valueOf(memList.get(position).get_id()));
            tv_mid.setText(memList.get(position).getMem_id());
            tv_pw.setText(memList.get(position).getMem_pw());
            tv_name.setText(memList.get(position).getMem_name());

        }
        return convertView;
    }
}
