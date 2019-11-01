package com.example.oracledb;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*

새로 만든 스레드에서 UI객체에 직접 접근하는 것은 불가합니다.
그래서 핸들러를 사용하기도 하지만 핸들러를 사용하면 코드가 복잡해짐.
이러한 Background 작업을 심플하게 하기 위해서 AyncTask클래스를
사용합니다.
AsynTask란 클래스를 상속하여 클래스를 만들면 해당 클래서안에 스레드를
위한 동작코드와 UI 접근 코드를 한꺼번에 넣을 수 있습니다.

예를 들면 웹서버에서 고객 아이디를 가져오는 작업과 판매제품 정보를
가져와야 하는 작업이 있을 때 서로 다른 코드로 분리시키고 싶으면
이 클래스를 상속받아서 코딩하면 된다.

스레드로 처리해야 하는 코드를 각각의 AsynTask클래스로 정의할 수 있음.
 */
public class LoginLogic extends AsyncTask<String,Void,String>
{
    String sendMsg = null;//안드로이드 앱에서 입력한 아이디와 비번을 담아서 전달할 변수 - 요청
    String receiveMsg = null;//톰캣서버를 통해 처리된 결과를 받아서 담을 변수 -응답

    @Override
    protected String doInBackground(String... strings){
        String apiURL = "http://192.168.0.244:8000/dev_jsp/android/androidLogin.jsp";
        try{
            URL url = new URL(apiURL);
            HttpURLConnection con =
                    (HttpURLConnection)url.openConnection();
            con.setRequestProperty
                    ("Content-Type","application/x-www-form-urlencoded");
            con.setRequestMethod("POST");
            OutputStreamWriter osw =
                    new OutputStreamWriter
                            (con.getOutputStream());
            sendMsg = "mem_id="+strings[0]+"&mem_pw="+strings[1];
            osw.write(sendMsg);
            osw.flush();
            //위에 요청에 대해 읽어올 준비
            int responseCode = con.getResponseCode();
            BufferedReader br = null;
            if(responseCode == con.HTTP_OK){
                br = new BufferedReader(new InputStreamReader(
                        con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer sb_res = new StringBuffer();
                while((inputLine = br.readLine())!=null){
                    sb_res.append(inputLine);
                }
                receiveMsg = sb_res.toString();
            }
            else{
                Log.d(this.getClass().getName()
                        ,"톰캣서버와 통신 실패");
            }
        }catch(Exception e){

        }
        return receiveMsg;
    }
}
