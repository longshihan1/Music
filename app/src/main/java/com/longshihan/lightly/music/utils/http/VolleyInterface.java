package com.longshihan.lightly.music.utils.http;

import android.content.Context;

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
public abstract class VolleyInterface {
    public Context context;
    public static Response.Listener<String> listener;
    public static Response.ErrorListener errorListener;

    public VolleyInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this.context = context;
        this.listener = listener;
        this.errorListener = errorListener;
    }

    //键值对成功
    public Response.Listener<String> loadingListener() {
        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                try {
                    onMySuccess(s);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }


            }
        };
        return listener;
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

    public abstract void onMySuccess(String result) throws Throwable;

    public abstract void onMyError(VolleyError error);
}
