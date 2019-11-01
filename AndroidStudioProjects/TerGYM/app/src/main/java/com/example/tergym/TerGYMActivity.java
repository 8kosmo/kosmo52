package com.example.tergym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

public class TerGYMActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tergym);
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout =
                findViewById(R.id.drawer_layout);
        //툴바에 버거아이콘 추가하기 위해서 객체 생성
        /***********************************
         * 1)버거아이콘 붙일 객체 주소번지 - Activity
         * 2)drawerLayout - 스와핑시 나올 화면 배치
         * 3)Toolbar - 버거아이콘을 툴바에 붙임
         * 4)열기에 사용할 문자상수
         * 5)닫기에 사용할 문자상수
         **********************************/
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this
                                          ,drawerLayout
                                          ,toolbar
                                          ,R.string.nav_open_drawer
                                          ,R.string.nav_close_drawer);
       //드로워 토글을 생성한 다음 DrawerLayout에
        //addDrawerListener메소드의 인자로 전달해서
        //레이아웃에 추가하기
        drawerLayout.addDrawerListener(toggle);
        //툴바의 아이콘과 드로워 상태를 동기화하는 메소드
        //드로워를 열려고 아이콘을 클릭하면 아이콘이 바뀌어야 하니까
        toggle.syncState();
        NavigationView navigationView =
                findViewById(R.id.nav_view);
        //사용자가 항목을 클릭하면 이를 통지 받을 수 있도록 네비게이션 뷰에
        //액티비티를 리스너로 등록함.
        navigationView.setNavigationItemSelectedListener(this);
        //프래그먼트 화면을 액티비티에 붙일때 필요한 코드
        //프래그먼트 인스턴스화
        Fragment fragment = new LoginFragment();
        //프래그먼트 모듈화 - 재사용성(화면처리)
        //프래그먼트를 여러개 붙일수도 있다.- 프래그먼트 매니저
        //프래그먼트트랜잭션 객체를 로딩한다.
        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame,fragment);
        ft.commit();
    }
/*
내비게이션 드로워의 아이템을 클릭하면 TerGYMActivity가 응답할 수
있도록 액티비티에서 NavigationView.OnNavigationItemSelectedListListener를 구현
그러면 사용자가 클릭할 때 마다 오버라이드한 onNavigationItemSelected가 호출.
이 메소드가 호출되면 선택한 옵션에 따라 적절할 화면을 보여줌.
사용자가 드로워에서 한 항목을 선택하면 이 메소드가 호출됨.
 */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        switch(id){
            case R.id.nav_pt:
                fragment = new PTFragment();
                break;
            default:
                fragment = new LoginFragment();
        }////////////////end of switch
        //insert here
        //너 프래그먼트 화면이니? - ft.commit()
        if(fragment !=null){
            FragmentTransaction ft =
                    getSupportFragmentManager().beginTransaction();
            ft.add(R.id.content_frame,fragment);
            ft.commit();
        }
        //너 액티비티야? - startActivity(intent)
        else{
            startActivity(intent);
        }
        //사용자가 옵션 중 하나를 선택하면 드로워를 닫아줌.
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
