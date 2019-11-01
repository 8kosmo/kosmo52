package com.example.pizza2019ver2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ShareActionProvider shareActionProvider = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(
                        getSupportFragmentManager());
/**/
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

    }/////////////end of onCreate
    /* 앱바 위에 +아이콘과 공유 아이콘 처리하기 */
    public boolean onCreateOptionsMenu(Menu menu){
        Log.d(TAG,"onCreateOptionsMenu 호출성공");
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (androidx.appcompat.widget.ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("우리 가게에서 주문할거야?");
        return super.onCreateOptionsMenu(menu);
    }

    /* 앱바에서 메뉴를 선택했을 때 */
    public boolean onOptionsItemSelected(MenuItem item){
        Log.d(TAG,"onOptionItemSelected:"+item);
        switch (item.getItemId()){
            case R.id.action_create_order:
                Log.d(TAG,"+버튼");
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
    }
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(TAG,"getItem 호출성공=>"+position);
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoreFragment();
            }
            return null;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home);
                case 1:
                    return getResources().getText(R.string.pizza);
                case 2:
                    return getResources().getText(R.string.pasta);
                case 3:
                    return getResources().getText(R.string.store);
            }
            return null;
        }
    }

}
