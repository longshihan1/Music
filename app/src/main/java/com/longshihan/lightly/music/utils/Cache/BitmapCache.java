package com.longshihan.lightly.music.utils.Cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2016/4/10.
 * 项目名称：Keep
 * 类描述：图片缓存
 * 创建人：longshihan
 * 创建时间：2016/4/10 15:16
 * 修改人：Administrator
 * 修改时间：2016/4/10 15:16
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class BitmapCache implements ImageLoader.ImageCache {
    public LruCache<String, Bitmap> cache;
    public int max = 10 * 1024 * 1024;

    public BitmapCache() {
        cache = new LruCache<String, Bitmap>(max) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String s) {

        return cache.get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        cache.put(s, bitmap);
    }

}
