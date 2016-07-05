package com.longshihan.lightly.music.fragment;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.MusicApp;
import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.activity.LocalMusicActivity;
import com.longshihan.lightly.music.utils.CommonUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalFragment extends Fragment {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    @InjectView(R.id.local_local)
    TextView mLocalLocal;
    @InjectView(R.id.local_msg)
    TextView mLocalMsg;
    @InjectView(R.id.local_sao)
    TextView mLocalSao;
    @InjectView(R.id.local_chuan)
    TextView mLocalChuan;
    @InjectView(R.id.local_shi)
    TextView mLocalShi;
    @InjectView(R.id.local_select)
    TextView mLocalSelect;
    @InjectView(R.id.local_yinxiao)
    TextView mLocalYinxiao;
    @InjectView(R.id.local_setting)
    TextView mLocalSetting;

    private Localmusic local_bean;
    private CommonUtils mCommonUtils;
    private List<Localmusic> mList1;
    //private LocalDao userDao = new LocalDao(getActivity());

    public static LocalFragment newInstance() {
        LocalFragment fragment = new LocalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_local, container, false);
        ButterKnife.inject(this, view);
        verifyStoragePermissions(getActivity());
        initView();
        return view;
    }

    private void initView() {
        mCommonUtils = new CommonUtils(getActivity());
        mList1 = new ArrayList<>();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @OnClick({R.id.local_local, R.id.local_msg, R.id.local_sao, R.id.local_chuan, R.id.local_shi,
            R.id.local_select, R.id.local_yinxiao, R.id.local_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.local_local:
                try {
                    List<Localmusic> lists=mCommonUtils.query_list(0,60);
                    Intent intent = new Intent(getActivity(), LocalMusicActivity.class);
                    intent.putExtra("list", (Serializable)lists);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();

                }

                break;
            case R.id.local_msg:
                break;
            case R.id.local_sao:
                Cursor cursor = getActivity().getContentResolver().query(MediaStore.Audio.Media
                                .EXTERNAL_CONTENT_URI,
                        null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    local_bean = new Localmusic();
                    //歌曲ID：MediaStore.Audio.Media._ID
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media
                            ._ID));
                    //歌曲的名称 ：MediaStore.Audio.Media.TITLE
                    String title_name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore
                            .Audio.Media.TITLE));
                    //歌曲的专辑名：MediaStore.Audio.Media.ALBUM
                    String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio
                            .Media.ALBUM));
                    //歌曲的歌手名： MediaStore.Audio.Media.ARTIST
                    String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore
                            .Audio.Media.ARTIST));
                    // 歌曲文件的全路径 ：MediaStore.Audio.Media.DATA
                    String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio
                            .Media.DATA));
                    // 歌曲文件的名称：MediaStroe.Audio.Media.DISPLAY_NAME
                    String display_name = cursor.getString(cursor.getColumnIndexOrThrow
                            (MediaStore.Audio.Media.DISPLAY_NAME));
                    //  歌曲文件的发行日期：MediaStore.Audio.Media.YEAR
                    String year = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio
                            .Media.YEAR));
                    // 歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
                    int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio
                            .Media.DURATION));
                    // 歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
                    long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio
                            .Media.SIZE));
                    String mime_type = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore
                            .Audio.Media.MIME_TYPE));
                    local_bean.setUid(id);
                    local_bean.setId((long) id);
                    local_bean.setTitle_name(title_name);
                    local_bean.setAlbum(album);
                    local_bean.setArtist(artist);
                    local_bean.setUrl(url);
                    local_bean.setDisplay_name(display_name);
                    local_bean.setYear(year);
                    local_bean.setDuration(duration);
                    local_bean.setSize(size);
                 /*   // 歌曲格式
                    if ("audio/mpeg".equals(mime_type)) {
                        song.setType("mp3");
                    } else if ("audio/x-ms-wma".equals(cursor.getString(7).trim())) {
                        song.setType("wma");
                    }*/
                    mList1.add(local_bean);
                    // mCommonUtils.insertMusic(local_bean);
                    //ormlite数据库框架
                    //  mLocalResu.data.add(local_bean);
                    //  userDao.addUser(local_bean);
                }
                cursor.close();
                mCommonUtils.insertMultMusic(mList1);

                //   PreferenceUtils.setObject(getActivity(),mLocalResu);


                break;
            case R.id.local_chuan:
                break;
            case R.id.local_shi:
                break;
            case R.id.local_select:
                break;
            case R.id.local_yinxiao:
                break;
            case R.id.local_setting:
                break;
        }
    }


    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        //访问媒体文件的权限
        int WRITE_EXTERNAL_STORAGE = ActivityCompat.checkSelfPermission(activity, Manifest
                .permission.WRITE_EXTERNAL_STORAGE);
        if (WRITE_EXTERNAL_STORAGE != PackageManager.PERMISSION_GRANTED) {
            // 我们没有权限，以提示用户
            ActivityCompat.requestPermissions(activity, MusicApp.PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

}
