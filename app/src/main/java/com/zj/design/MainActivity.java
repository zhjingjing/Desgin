package com.zj.design;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zj.design.activity.SettingActivity;
import com.zj.design.adapter.MyPagerAdapter;
import com.zj.design.base.BaseFragment;
import com.zj.design.fragment.HotFragment;
import com.zj.design.fragment.NearFragment;
import com.zj.design.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ViewPager viewPager;
    TabLayout tabLayout;
    MyPagerAdapter myPagerAdapter;
    List<BaseFragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigation();
        initViewPager();
    }

    public void initNavigation() {
        navigationView = findViewById(R.id.navigation_view);
        //这里可以添加多个headview
        View headView1 = LayoutInflater.from(this).inflate(R.layout.layout_navigation_head, null);
        navigationView.addHeaderView(headView1);

        //根据headview的下标设置点击事件
        navigationView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这里是头部，点击跳转个人信息", Toast.LENGTH_LONG).show();
            }
        });
        navigationView.getHeaderView(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "请点击第一个", Toast.LENGTH_LONG).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_follow:
                        Toast.makeText(MainActivity.this, "关注", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_setting:
                        SettingActivity.launch(MainActivity.this);
                        break;
                    case R.id.menu_user:
                        Toast.makeText(MainActivity.this, "个人空间", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_version:
                        Toast.makeText(MainActivity.this, "当前版本已经是最新版本了", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });

    }

    public void initViewPager() {
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tab_layout);
        list = new ArrayList<>();

        list.add(RecommendFragment.getInstance());
        list.add(HotFragment.getInstance());
        list.add(NearFragment.getInstance());
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}
