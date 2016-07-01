package com.longshihan.lightly.music;

import android.Manifest;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @time 2016/6/13 15:20
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class MusicApp extends Application {
    private static MusicApp _instance;
    public static Context applicationContext;
    private  static MusicApp application;
    public static RequestQueue queues;
    private static final String WELCOME_GUIDE = "welcome_guide";

    public static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE
            , Manifest.permission.WRITE_EXTERNAL_STORAGE
            , Manifest.permission.WRITE_CONTACTS
            , Manifest.permission.GET_ACCOUNTS
            , Manifest.permission.READ_CONTACTS
            , Manifest.permission.READ_CALL_LOG
            , Manifest.permission.READ_PHONE_STATE
            , Manifest.permission.CALL_PHONE
            , Manifest.permission.WRITE_CALL_LOG
            , Manifest.permission.USE_SIP
            , Manifest.permission.PROCESS_OUTGOING_CALLS
            , Manifest.permission.ADD_VOICEMAIL
            , Manifest.permission.READ_CALENDAR
            , Manifest.permission.WRITE_CALENDAR
            , Manifest.permission.CAMERA
            , Manifest.permission.CAMERA
            , Manifest.permission.BODY_SENSORS
            , Manifest.permission.ACCESS_FINE_LOCATION
            , Manifest.permission.ACCESS_COARSE_LOCATION
            , Manifest.permission.READ_EXTERNAL_STORAGE
            , Manifest.permission.WRITE_EXTERNAL_STORAGE
            , Manifest.permission.RECORD_AUDIO
            , Manifest.permission.READ_SMS
            , Manifest.permission.RECEIVE_WAP_PUSH
            , Manifest.permission.RECEIVE_MMS
            , Manifest.permission.RECEIVE_SMS
            , Manifest.permission.SEND_SMS
    };

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    /*
    * 初始化TAG
    * */
    private static String TAG = MusicApp.class.getName();

    /*Activity堆*/
    private Stack<AppCompatActivity> activityStack = new Stack<AppCompatActivity>();

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        initConfig(getApplicationContext());
        _instance = this;
        applicationContext=this;
        x.Ext.init(this);
        // 设置是否输出debug
        x.Ext.setDebug(true);

        queues= Volley.newRequestQueue(getApplicationContext());

      /*  // 初始化 Bmob SDK
        Bmob.initialize(getApplicationContext(), Constans.Bmob_APPID);
        //初始化sharedSDK的短信SDK
        SMSSDK.initSDK(this, Constans.Mob_SMS_ID, Constans.MOb_SMS_SCRECT);
        SharePreferenceUtils.init(this);
        ShareSDK.initSDK(this);
*/



        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);

        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
        printAppParameter();
    }

    /*打印出一些app的参数*/
    private void printAppParameter() {
        Log.d(TAG, "OS : " + Build.VERSION.RELEASE + " ( " + Build.VERSION.SDK_INT + " )");

    }

    public void addActivity(final AppCompatActivity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<AppCompatActivity>();
        }
        activityStack.add(curAT);
    }

    public void removeActivity(final AppCompatActivity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<AppCompatActivity>();
        }
        activityStack.remove(curAT);
    }

    //获取最后一个Activity
    public AppCompatActivity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) {
            return null;
        }
        AppCompatActivity activity = activityStack.lastElement();
        return activity;
    }

    //返回寨内Activity的总数
    public int howManyActivities() {
        return activityStack.size();
    }

    //关闭所有Activity
    public void finishAllActivities() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束当前Activity（栈顶Activity）
     */
    public void finishActivity() {
        AppCompatActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(AppCompatActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 初始化文件配置
     *
     * @param context
     */
    public static void initConfig(Context context) {
       /* BmobConfiguration config = new BmobConfiguration.Builder(context).customExternalCacheDir("Smile").build();
        BmobPro.getInstance(context).initConfig(config);*/
    }

    public static MusicApp getApplication(){
        return application;
    }
    public static MusicApp instance() {
        return _instance;
    }

    public void exit() {
        finishAllActivities();

        android.os.Process.killProcess(android.os.Process.myPid());

        System.exit(0);

    }
    /**
     * 判断程序是否是第一次启动，如果是第一次启动，需要显示引导页面
     *
     * @return
     */
    public boolean getIsNeedWelcomeGuide() {

        int currentVersion = MusicApp.instance().getVersionCode();

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        final int lastVersion = sharedPreferences.getInt(WELCOME_GUIDE, -1);
        if (currentVersion > lastVersion) {
            sharedPreferences.edit().putInt(WELCOME_GUIDE, currentVersion).commit();
            return true;
        }
        return false;
    }

    /**
     * 获取版本号标示
     *
     * @return
     */
    public int getVersionCode() {
        String packageName = getPackageName();
        try {
            return getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // Log.e(TAG, e.getMessage());
        }
        return 0;
    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this
                .getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i
                    .next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm
                            .getApplicationInfo(info.processName,
                                    PackageManager.GET_META_DATA));
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
            }
        }
        return processName;
    }
    //全局的请求队列
    public static RequestQueue getHttpQueues(){
        return queues;
    }



}
