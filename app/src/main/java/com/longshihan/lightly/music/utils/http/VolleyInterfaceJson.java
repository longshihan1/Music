package com.longshihan.lightly.music.utils.http;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：Volley的成功失败的监听_Json
 * 创建人：longshihan
 * 创建时间：2016/4/11 10:04
 * 修改人：Administrator
 * 修改时间：2016/4/11 10:04
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public abstract class VolleyInterfaceJson {
    public Context context;
    public static Response.Listener<JSONObject> jlistener;
    public static Response.ErrorListener errorListener;

    public VolleyInterfaceJson(Context context, Response.Listener<JSONObject> jlistener, Response.ErrorListener errorListener) {
        this.context = context;
        this.errorListener = errorListener;
        this.jlistener=jlistener;
    }

    //json成功
    public Response.Listener<JSONObject> loadingListener() {
        jlistener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                onMySuccess(jsonObject);
            }
        };
        return jlistener;
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


    public abstract void onMySuccess(JSONObject jsonObject);

    public abstract void onMyError(VolleyError error);
}
