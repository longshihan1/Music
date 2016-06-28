package com.longshihan.lightly.music.utils.http;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：Volley的成功失败的监听_String
 * 创建人：longshihan
 * 创建时间：2016/4/11 10:04
 * 修改人：Administrator
 * 修改时间：2016/4/11 10:04
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public abstract class VolleyInterfaceBitmap {
    public Context context;
    public static Response.Listener<Bitmap> bitmaplistener;
    public static Response.ErrorListener errorListener;

    public VolleyInterfaceBitmap(Context context, Response.Listener<Bitmap> bitmaplistener, Response.ErrorListener errorListener) {
        this.context = context;
        this.bitmaplistener = bitmaplistener;
        this.errorListener = errorListener;
    }

    //键值对成功
    public Response.Listener<Bitmap> loadingListener() {
        bitmaplistener = new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap bitmap) {

            }
        };
        return bitmaplistener;
    }

    //失败
    public Response.ErrorListener errorListener() {
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onMyError(volleyError);
            }

        };
        return errorListener;
    }

    public abstract void onMySuccess(Bitmap bitmap);

    public abstract void onMyError(VolleyError error);
}
