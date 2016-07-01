package com.longshihan.lightly.music.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.HomePageAdapter;
import com.longshihan.lightly.music.fragment.AlbumFragment;
import com.longshihan.lightly.music.fragment.AuthorFragment;
import com.longshihan.lightly.music.fragment.FileFragment;
import com.longshihan.lightly.music.fragment.LocalMusicNameFragment;
import com.longshihan.lightly.music.utils.CommonUtils;
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
    private LocalMusicNameFragment localMusicNameFragment;
    private AuthorFragment mAuthorFragment;
    private AlbumFragment mAlbumFragment;
    private FileFragment mFileFragment;
    private CommonUtils mCommonUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {





        if (localMusicNameFragment.newInstance()==null){
            localMusicNameFragment=new LocalMusicNameFragment();
        }


      /*  mCommonUtils = new CommonUtils(this);
        List<Localmusic> lists=mCommonUtils.listall();
        Log.e("changdu",lists.size()+"");*/

        mAlbumFragment=new AlbumFragment();
        mAuthorFragment=new AuthorFragment();
        mFileFragment=new FileFragment();

        mLocalViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLocalTitle = (ColumnHorizontalScrollView) findViewById(R.id.home_title);
        fragmentList.add(localMusicNameFragment);
        fragmentList.add(mAlbumFragment);
        fragmentList.add(mAuthorFragment);
        fragmentList.add(mFileFragment);
        mHomePageAdapter = new HomePageAdapter(getSupportFragmentManager(), fragmentList);
        mLocalViewPager.setAdapter(mHomePageAdapter);
        mLocalTitle.setTitle("单曲", "歌手", "专辑", "文件夹");
        mLocalTitle.setspace(80);
        mLocalTitle.setViewPager(mLocalViewPager);

    }
}
