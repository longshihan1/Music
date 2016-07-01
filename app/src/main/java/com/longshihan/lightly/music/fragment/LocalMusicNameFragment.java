package com.longshihan.lightly.music.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.DANMusicRecyclerViewAdapter;
import com.longshihan.lightly.music.db.DaoManager;
import com.longshihan.lightly.music.utils.CommonUtils;
import com.longshihan.lightly.music.view.FullyLinearLayoutManager;

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

    public static LocalMusicNameFragment newInstance() {
        LocalMusicNameFragment fragment = new LocalMusicNameFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public LocalMusicNameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_music_name, container, false);
        ButterKnife.inject(this, view);
        context=getActivity();

        initView();
        return view;
    }

    private void initView() {
      /*  mCommonUtils = new CommonUtils(context);
        List<Localmusic> lists=mCommonUtils.listall();
        */
       /* mDaoManager = DaoManager.getInstance();
        mDaoManager.init(getActivity().getApplication());*/
      //  List<Localmusic> lists= mDaoManager.getDaoSession().loadAll(Localmusic.class);
        mFullyLinearLayoutManager = new FullyLinearLayoutManager(context);
        mFullyLinearLayoutManager.setOrientation(FullyLinearLayoutManager.VERTICAL);
        mLocalMusicRecy.setLayoutManager(mFullyLinearLayoutManager);

     //   adapter = new DANMusicRecyclerViewAdapter(context,lists);
        mLocalMusicRecy.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
