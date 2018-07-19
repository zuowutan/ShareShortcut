package com.share.shortcut;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by tzw on 2018/7/19.
 */

public class BaseActivity extends Activity{

    //设置横竖屏幕的切换 默认是竖屏
    public boolean setRequestedBoolean = true;

    public final String TAG = "app";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (setRequestedBoolean) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    /**
     * 功能描述:简单地 Activity 的跳转(不携带任何数据)
     *
     * @param activity 发起跳转的 Activity 实例
     * @param cls      目标 Activity 实例
     */
    public void skipAnotherActivity(Activity activity,
                                    Class<? extends Activity> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }


    /**
     * 返回主页
     * @param activity
     */
    public void goBackMainActivity(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

}
