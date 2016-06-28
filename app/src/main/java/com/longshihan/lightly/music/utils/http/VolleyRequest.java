package com.longshihan.lightly.music.utils.http;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.longshihan.lightly.music.MusicApp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：封装Volley的get和post请求
 * 创建人：longshihan
 * 创建时间：2016/4/11 10:05
 * 修改人：Administrator
 * 修改时间：2016/4/11 10:05
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class VolleyRequest {
    public static StringRequest stringRequest;
    public static Context context;
    public static JsonRequest<JSONObject> jsonRequest;
    public static ImageRequest imageRequest;

    //get封装
    public static void RequestGet(Context context, String url, String tag, VolleyInterface volleyInterface) {
        MusicApp.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, volleyInterface.loadingListener(), volleyInterface.errorListener())
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<>();
                    params.put("Content-Type", "text/html; charset=gbk");
                    return params;
            }
        };

        stringRequest.setTag(tag);
        MusicApp.getHttpQueues().add(stringRequest);
        MusicApp.getHttpQueues().start();
    }

    //键值对的post封装
    public static void RequestPost(Context context, String url, String tag, final Map<String, String> params, VolleyInterface volleyInterface) {
        MusicApp.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(url, volleyInterface.loadingListener(), volleyInterface.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MusicApp.getHttpQueues().add(stringRequest);
        MusicApp.getHttpQueues().start();
    }

    //json的post封装
    public static void RequestPostJson(Context context, String url, String tag, JSONObject jsonObject, VolleyInterfaceJson volleyInterfaceJson) {
        MusicApp.getHttpQueues().cancelAll(tag);
        jsonRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, volleyInterfaceJson.loadingListener(), volleyInterfaceJson.errorListener());
        jsonRequest.setTag(tag);
        MusicApp.getHttpQueues().add(jsonRequest);
        MusicApp.getHttpQueues().start();
    }

    public static void RequestImage(Context context, String url, String tag, VolleyInterfaceBitmap volleyInterfaceBitmap){
        MusicApp.getHttpQueues().cancelAll(tag);
        imageRequest = new ImageRequest( url, volleyInterfaceBitmap.loadingListener(),300,500, Bitmap.Config.RGB_565, volleyInterfaceBitmap.errorListener());
        imageRequest.setTag(tag);
        MusicApp.getHttpQueues().add(imageRequest);
        MusicApp.getHttpQueues().start();

    }

}
