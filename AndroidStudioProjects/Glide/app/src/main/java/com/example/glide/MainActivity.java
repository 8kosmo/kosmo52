package com.example.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/*
Glide라이브러리는 이미지 핸들링을 제공하기 위한 라이브러리임
HTTP연동에 의한 서버 이미지 뿐 아니라 리소스, 파일이미지도 쉽게
가져올 수 있으면 썸네일 보기, 로딩이미지 출력, 동영상 스틸 보기등
을 지원함.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv_load = findViewById(R.id.iv_load);
        ImageView iv_google = findViewById(R.id.iv_google);
        Glide.with(this)
                .load(R.raw.loading)
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .override(200,200)
                .into(iv_load);
        String url = "http://192.168.0.244:8000/images/googlelogo_color_272x92dp.png";
        Glide.with(this)
                .load(url)
                .override(400,400)
                .error(R.drawable.error)
                .into(iv_google);

    }
}
