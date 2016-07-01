package com.longshihan.lightly.music.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.LocalMusic_viewpage_adapter;
import com.longshihan.lightly.music.fragment.AlbumFragment;
import com.longshihan.lightly.music.fragment.AritstFragment;
import com.longshihan.lightly.music.fragment.FileFragment;
import com.longshihan.lightly.music.fragment.LocalMusicNameFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LocalMusicActivity extends AppCompatActivity {

    @InjectView(R.id.localmusic_pagertitle)
    PagerTitleStrip mLocalmusicPagertitle;
    @InjectView(R.id.localmusic_viewpager)
    ViewPager mLocalmusicViewpager;

    private List<Fragment> list_fragment;// view数组

    private List<String> titleList;  //标题列表数组
    private List<Localmusic> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_music);
        ButterKnife.inject(this);

        mList = (List<Localmusic>) getIntent().getSerializableExtra("list");

        initView();
    }

    private void initView() {
        list_fragment = new ArrayList<>();
        list_fragment.add(new LocalMusicNameFragment());
        list_fragment.add(new AritstFragment());
        list_fragment.add(new AlbumFragment());
        list_fragment.add(new FileFragment());

        titleList = new ArrayList<>();
        titleList.add("单曲");
        titleList.add("歌手");
        titleList.add("专辑");
        titleList.add("文件");

        mLocalmusicViewpager.setAdapter(new LocalMusic_viewpage_adapter(getSupportFragmentManager
                (), list_fragment, titleList));

    }


}

