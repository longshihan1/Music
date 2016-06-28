package com.longshihan.lightly.music.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.HomePageAdapter;
import com.longshihan.lightly.music.fragment.AlbumsFragment;
import com.longshihan.lightly.music.fragment.AuthorFragment;
import com.longshihan.lightly.music.fragment.FileFragment;
import com.longshihan.lightly.music.fragment.MusicDANFragment;
import com.longshihan.lightly.music.view.ColumnHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LocalActivity extends AppCompatActivity {

    @InjectView(R.id.local_title)
    ColumnHorizontalScrollView mLocalTitle;
    @InjectView(R.id.local_viewPager)
    ViewPager mLocalViewPager;

    List<Fragment> fragmentList = new ArrayList<>();
    private HomePageAdapter mHomePageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        mLocalViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLocalTitle = (ColumnHorizontalScrollView) findViewById(R.id.home_title);
        fragmentList.add(new MusicDANFragment());
        fragmentList.add(new AuthorFragment());
        fragmentList.add(new AlbumsFragment());
        fragmentList.add(new FileFragment());
        mHomePageAdapter = new HomePageAdapter(getSupportFragmentManager(), fragmentList);
        mLocalViewPager.setAdapter(mHomePageAdapter);
        mLocalTitle.setTitle("单曲", "歌手", "专辑", "文件夹");
        mLocalTitle.setspace(80);
        mLocalTitle.setViewPager(mLocalViewPager);

    }
}
