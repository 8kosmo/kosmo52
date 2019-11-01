package com.example.matisse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_img = null;
    LinearLayout linearLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //반드시 xml문서를 스캔한 후에 처리할 것.
        btn_img = findViewById(R.id.btn_img);
        linearLayout = findViewById(R.id.layout);
        btn_img.setOnClickListener(this);
        if(ContextCompat.checkSelfPermission
                (this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                !=
                PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission
                (this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this
                    ,new String[]
                            {Manifest.permission.READ_EXTERNAL_STORAGE
                                    ,Manifest.permission.WRITE_EXTERNAL_STORAGE}
                                    ,200);
        }
    }

    @Override
    public void onClick(View v) {
        Matisse.from(this)
        .choose(MimeType.of(MimeType.AVI.JPEG))
        .countable(true)
        .maxSelectable(9)
        .spanCount(3)
        .imageEngine(new GlideEngine())
        .forResult(100);
    }
    @Override
    protected void onActivityResult(int requestCode
                                  , int resultCode
                                  , Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==100 && resultCode==RESULT_OK){
            List<Uri> mSelected = Matisse.obtainResult(data);
            for(Uri uri:mSelected) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT
                                , ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayout.addView(imageView, params);
                Glide.with(this)
                        .load(uri)
                        .override(400,400)
                        .into(imageView);
            }

        }
    }
}
