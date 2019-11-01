package com.example.book72.ui.login;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginLogic extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {
        String apiURL = "http://192.168.0.244:8000/android/androidTalk.jsp";
        String msg = null;
        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            con.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            //안드로이드에서 서버로 전송할 정보를 전달할 때 사용함
            //파라미터에 값을 넘김
            osw.write("send message");
            osw.flush();
            //여기서 부터는 위에 요청에 대한 응답을 받아오는 코드를 작성해야함.
            int responseCode = con.getResponseCode();
            BufferedReader br = null;
            //톰캣 서버로 부터 정상적으로 응답을 받았을 때 200번이므로
            //이 값을 비교하여 조건을 만족했을 때 처리
            if(responseCode == con.HTTP_OK){
                br = new BufferedReader(
                        new InputStreamReader(
                                con.getInputStream()
                                ,"UTF-8"));
                String inputLine = null;
                StringBuffer sb = new StringBuffer();
                while ((inputLine=br.readLine())!=null){
                    sb.append(inputLine);
                }
                msg = sb.toString();
                Log.d(this.getClass().getName(),"msg===>"+msg);
            }
            else{
                br = new BufferedReader
                        (new InputStreamReader(con.getErrorStream()));
                Log.d(this.getClass().getName(),"톰캣서버와 통신 실패");
            }
        }catch(Exception e){
            e.printStackTrace();
            Log.d(this.getClass().getName(),e.toString());
        }
        return msg;
    }
}
