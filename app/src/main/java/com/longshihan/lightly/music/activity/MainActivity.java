package com.longshihan.lightly.music.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.HomePageAdapter;
import com.longshihan.lightly.music.fragment.NetMusicFragment;
import com.longshihan.lightly.music.fragment.PersonFragment;
import com.longshihan.lightly.music.fragment.RecommendFragment;
import com.longshihan.lightly.music.view.ColumnHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ImageView mSreach;

    ImageView mSetting;

    ViewPager mViewPager;

    ColumnHorizontalScrollView mHomeTitle;

    /**
     * 页面list
     **/
    List<Fragment> fragmentList = new ArrayList<>();
    private HomePageAdapter mHomePageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mHomeTitle = (ColumnHorizontalScrollView) findViewById(R.id.home_title);
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new NetMusicFragment());
        fragmentList.add(new PersonFragment());
        mHomePageAdapter = new HomePageAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(mHomePageAdapter);
        mHomeTitle.setTitle("推荐", "音乐圈", "我的");
        mHomeTitle.setspace(80);
        mHomeTitle.setViewPager(mViewPager);


    }


}
