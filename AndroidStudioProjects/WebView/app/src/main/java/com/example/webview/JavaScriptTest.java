package com.example.webview;

import android.webkit.JavascriptInterface;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptTest {
    @JavascriptInterface
    public String getEmpList(){
        String temp = null;
        List<String> nameList = new ArrayList<>();
        nameList.add("이순신");
        nameList.add("강감찬");
        nameList.add("김유신");
        Gson g = new Gson();
        temp = g.toJson(nameList);
        return temp;
    }
}
