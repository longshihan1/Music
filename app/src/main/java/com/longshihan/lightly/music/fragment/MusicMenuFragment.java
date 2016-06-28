package com.longshihan.lightly.music.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longshihan.lightly.music.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicMenuFragment extends Fragment {

    public static MusicMenuFragment newInstance() {
        MusicMenuFragment fragment = new MusicMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public MusicMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_menu, container, false);
    }

}
