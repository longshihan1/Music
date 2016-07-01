package com.longshihan.lightly.music.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FileFragment extends Fragment {


    public FileFragment(List<Localmusic> list) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_file, container, false);
    }

}
