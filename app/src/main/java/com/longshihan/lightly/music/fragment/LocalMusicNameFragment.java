package com.longshihan.lightly.music.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.DANMusicRecyclerViewAdapter;
import com.longshihan.lightly.music.db.DaoManager;
import com.longshihan.lightly.music.server.AudioPlayer;
import com.longshihan.lightly.music.utils.CommonUtils;
import com.longshihan.lightly.music.view.FullyLinearLayoutManager;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalMusicNameFragment extends Fragment {

    private FullyLinearLayoutManager mFullyLinearLayoutManager;
    private DANMusicRecyclerViewAdapter adapter;
    private CommonUtils mCommonUtils;
    private Context context;
    @InjectView(R.id.local_music_recy)
    RecyclerView mLocalMusicRecy;
    private DaoManager mDaoManager;
    private List<Localmusic> mList;

    public LocalMusicNameFragment newInstance() {
        LocalMusicNameFragment fragment = new LocalMusicNameFragment(mList);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public LocalMusicNameFragment(List<Localmusic> list) {
        this.mList = list;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_music_name, container, false);
        ButterKnife.inject(this, view);
        context = getActivity();

        initView();
        return view;
    }

    private void initView() {
        mFullyLinearLayoutManager = new FullyLinearLayoutManager(context);
        mFullyLinearLayoutManager.setOrientation(FullyLinearLayoutManager.VERTICAL);
        mLocalMusicRecy.setLayoutManager(mFullyLinearLayoutManager);
        adapter = new DANMusicRecyclerViewAdapter(context, mList);
        mLocalMusicRecy.setAdapter(adapter);

        adapter.setOnItemClickLitener(new DANMusicRecyclerViewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AudioPlayer.play();
                    }
                }).start();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
