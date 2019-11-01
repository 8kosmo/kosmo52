package com.example.membermanager;

import java.lang.reflect.Member;

public class MemberVO {
    private int _id = 0;
    private String mem_id = null;
    private String mem_pw = null;
    private String mem_name = null;
    public MemberVO(){}
    public MemberVO(int _id, String mem_id, String mem_pw, String mem_name){
        this._id = _id;
        this.mem_id = mem_id;
        this.mem_pw = mem_pw;
        this.mem_name = mem_name;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }
}
