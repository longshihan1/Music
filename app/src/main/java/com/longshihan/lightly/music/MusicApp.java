package com.longshihan.lightly.music;

import android.app.Application;
import android.content.res.Configuration;

import org.xutils.x;

/**
 * @author Administrator
 * @time 2016/6/13 15:20
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class MusicApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initView();
    }

    private void initView() {

        x.Ext.init(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
