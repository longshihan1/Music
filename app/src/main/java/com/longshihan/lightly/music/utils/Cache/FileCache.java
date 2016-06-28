package com.longshihan.lightly.music.utils.Cache;

import android.content.Context;

import java.io.File;

/**
 * Created by Administrator on 2016/4/6.
 * 项目名称：Keep
 * 类描述：图片的文件缓存
 * 创建人：Administrator
 * 创建时间：2016/4/6 17:20
 * 修改人：Administrator
 * 修改时间：2016/4/6 17:20
 * 修改备注：
 */
public class FileCache {
    private File cacheDir;

    public FileCache(Context context) {
        // 如果有SD卡则在SD卡中建一个LazyList的目录存放缓存的图片
        // 没有SD卡就放在系统的缓存目录中
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
            cacheDir = new File(
                    android.os.Environment.getExternalStorageDirectory(),
                    ".keep_cache");
        else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url) {
        // 将url的hashCode作为缓存的文件名
        String filename = String.valueOf(url.hashCode());
        // Another possible solution
        // String filename = URLEncoder.encode(url);
        File f = new File(cacheDir, filename);
        return f;

    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
            return;
        for (File f : files)
            f.delete();
    }

}
