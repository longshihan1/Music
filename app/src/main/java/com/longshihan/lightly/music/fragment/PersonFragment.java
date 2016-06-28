package com.longshihan.lightly.music.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.HomePageAdapter;
import com.longshihan.lightly.music.view.ColumnHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 我的界面-fragment
 *
 * @author longshihan
 *         created at 2016/6/22 15:41
 */
public class PersonFragment extends Fragment {


    @InjectView(R.id.udyu)
    TextView mUdyu;
    @InjectView(R.id.person_title)
    ColumnHorizontalScrollView mPersonTitle;
    @InjectView(R.id.person_viewpage)
    ViewPager mPersonViewpage;

    public static PersonFragment newInstance() {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public PersonFragment() {
        // Required empty public constructor
    }
    /**
     * 页面list
     **/
    List<Fragment> fragmentList = new ArrayList<>();
    private HomePageAdapter mHomePageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        ButterKnife.inject(this, view);
        fragmentList.add(new LocalFragment());
        fragmentList.add(new MusicMenuFragment());
        fragmentList.add(new DownloadFragment());
        fragmentList.add(new PlayFragment());
        mHomePageAdapter = new HomePageAdapter(getChildFragmentManager(), fragmentList);
        mPersonViewpage.setAdapter(mHomePageAdapter);
        mPersonTitle.setTitle("本地", "歌单", "下载","播放");
        mPersonTitle.setspace(80);
        mPersonTitle.setViewPager(mPersonViewpage);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
