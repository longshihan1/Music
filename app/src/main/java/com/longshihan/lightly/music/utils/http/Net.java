package com.longshihan.lightly.music.utils.http;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：
 * 创建人：longshihan
 * 创建时间：2016/4/11 10:05
 * 修改人：Administrator
 * 修改时间：2016/4/11 10:05
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class Net {
    public static final String tag = "NET";
    public static final int SUCCESS = 1000000;
    public static final int ERROR = 1000001;
    public static final String UTF_8 = "UTF-8";

    //volley的get请求
    //context上下文，handler将数据抛出去，tag标记，msg弹出文字，
    public static synchronized void sendHttpGet(Context context, final Handler handler, final String tag, String url,String type,String size,String offset) {
        if (type!=null&&size!=null&&offset!=null){
            url=url+"&type="+type+"&size="+size+"&offset="+offset;
        }
        VolleyRequest.RequestGet(context, url, tag, new VolleyInterface(context, VolleyInterface
                .listener, VolleyInterface.errorListener) {
                    @Override
                    public void onMySuccess(String result) throws Throwable {
                        ChangeCharset test = new ChangeCharset();
                        Message msg1 = handler.obtainMessage();
                        msg1.what = SUCCESS;
                       // String resulter1 = test.toUTF_8(result);

                       /* String jsonString =
                                new String(result, HttpHeaderParser.parseCharset(result.hashCode()));*/
                        msg1.obj = result;
                        handler.sendMessage(msg1);
                    }

                    @Override
                    public void onMyError(VolleyError error) {
                        Message message = handler.obtainMessage(ERROR);
                        handler.sendMessage(message);
                    }
                }
        );
    }

    //volley的post请求-->请求参数键值对
    //context上下文，handler将数据抛出去，tag标记，msg弹出文字，url访问网址，params所带参数
    public static synchronized void sendHttpPost(Context context, final Handler handler, String
            tag, String msg, String url, final Map<String, String> params) {

        VolleyRequest.RequestPost(context, url, tag, params, new VolleyInterface(context,
                VolleyInterface.listener, VolleyInterface.errorListener) {

            @Override
            public void onMySuccess(String result) {

                Message msg1 = handler.obtainMessage();
                msg1.what = SUCCESS;

                msg1.obj = result;
                handler.sendMessage(msg1);

            }

            @Override
            public void onMyError(VolleyError error) {
                Message message = handler.obtainMessage(ERROR);
                handler.sendMessage(message);
            }

        });
    }

    //volley的post请求-->请求参数为json
    //context上下文，handler将数据抛出去，tag标记，msg弹出文字，url访问网址，jsonObject为参数
    public static synchronized void sendHttpPostJson(Context context, final Handler handler,
                                                     String tag, String msg, String url, final
                                                     JSONObject jsonObject) {

        VolleyRequest.RequestPostJson(context, url, tag, jsonObject, new VolleyInterfaceJson
                (context, VolleyInterfaceJson.jlistener, VolleyInterfaceJson.errorListener) {

            @Override
            public void onMySuccess(JSONObject jsonObject) {
                Message msg1 = handler.obtainMessage();
                msg1.what = SUCCESS;
                msg1.obj = jsonObject.toString();
                handler.sendMessage(msg1);

            }

            @Override
            public void onMyError(VolleyError error) {
                Message message = handler.obtainMessage(ERROR);
                handler.sendMessage(message);
            }

        });
    }

    //volley的请求图像
    //context上下文，handler将数据抛出去，tag标记，msg弹出文字，url访问网址
    public static synchronized void sendHttpBitmap(Context context, final Handler handler, String
            tag, String msg, final String url) {
        VolleyRequest.RequestImage(context, url, tag, new VolleyInterfaceBitmap(context,
                VolleyInterfaceBitmap.bitmaplistener, VolleyInterfaceBitmap.errorListener) {

            @Override
            public void onMySuccess(Bitmap bitmap) {
                Log.e("我瞅瞅", url);
                Message msg1 = handler.obtainMessage();
                msg1.what = SUCCESS;
                msg1.obj = bitmap;
                handler.sendMessage(msg1);
            }

            @Override
            public void onMyError(VolleyError error) {
                Log.e("我瞅瞅", error.toString());
                Message message = handler.obtainMessage(ERROR);
                handler.sendMessage(message);
            }
        });

    }

    public static String recover(String str) throws Throwable {
        return new String(str.getBytes("GBK"), "UTF-8");
    }

}
