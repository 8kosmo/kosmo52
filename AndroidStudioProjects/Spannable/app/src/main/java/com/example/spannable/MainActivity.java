package com.example.spannable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_span = findViewById(R.id.tv_span);
        String data = "복수초 \n img \n 이른봄 설산에서 만나는 복수초는.....";
        //문자열의 시작위치
        int start = data.indexOf("img");
        SpannableStringBuilder builder = new SpannableStringBuilder(data);
        if(start>-1) {
            int end = start + "img".length();

            //이미지 정보 가져오기
            Drawable dr =
                    ResourcesCompat.getDrawable(
                            getResources(), R.drawable.img1
                            , null);
            //이미지 화면 출력 정보 설정
            dr.setBounds(0, 0, dr.getIntrinsicWidth()
                    , dr.getIntrinsicHeight());
            //ImageScan준비
            ImageSpan span = new ImageSpan(dr);
            builder.setSpan(span, start, end
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        start = data.indexOf("복수초");
        if(start>-1){
            int end = start+"복수초".length();
            StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
            //기본 크기보다 2배수 크게 표현하기
            RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);
            builder.setSpan(styleSpan, start, end
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(sizeSpan, start, end
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv_span.setText(builder);
        TextView tv_html = findViewById(R.id.tv_html);
        String html = "<font color='red'>수목원</font><br/><img src='img1'/><br>아침고요수목원에서 만난 봄꽃";
        tv_html.setText(Html.fromHtml(html,new MyImage(),null));
    }
    class MyImage implements Html.ImageGetter{

        @Override
        public Drawable getDrawable(String source) {
            if(source.equals("img1")){
                //이미지 획득
                Drawable dr = ResourcesCompat.getDrawable(
                        getResources(),R.drawable.img2,null);
                dr.setBounds(0,0,dr.getIntrinsicWidth(),dr.getIntrinsicHeight());
                return dr;
            }
            return null;
        }
    }
}
