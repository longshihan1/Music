package com.longshihan.lightly.music.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Administrator
 * @time 2016/7/1 11:03
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class LocalMusic_viewpage_adapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;// view数组

    private List<String> titleList;  //标题列表数组

    public LocalMusic_viewpage_adapter(FragmentManager fm, List<Fragment> list_fragment,
            List<String>titleList) {
        super(fm);
        this.list_fragment = list_fragment;
        this.titleList = titleList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }
}
