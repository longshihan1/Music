package com.longshihan.lightly.music.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longshihan.lightly.music.R;

/**
*音乐圈-fragment
*@author longshihan
*created at 2016/6/22 15:40
*
*/
public class NetMusicFragment extends Fragment {

    public static NetMusicFragment newInstance() {
        NetMusicFragment fragment = new NetMusicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public NetMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_net_music, container, false);
    }

}
