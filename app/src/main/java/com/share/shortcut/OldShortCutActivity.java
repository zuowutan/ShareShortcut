package com.share.shortcut;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by tzw on 2018/7/19.
 * 传统创建Activity快捷方式
 */

public class OldShortCutActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old);

        findViewById(R.id.create_old).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              创建图标
                createShortCut();
//
            }
        });



        findViewById(R.id.goback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackMainActivity(OldShortCutActivity.this);
            }
        });

    }




    /**
     * 实践一:
     */
    public void installShortCut( Context mContext) {
        Intent resultIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        // 快捷方式的名称
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "嘿嘿嘿");
        resultIntent.putExtra("duplicate", false); // 不允许重复创建
        // 快捷方式的图标
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(mContext, R.drawable.ic_launcher_foreground);
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);

        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");// 桌面图标和应用绑定，卸载应用后系统会同时自动删除图标
        intent.addCategory("android.intent.category.LAUNCHER");// 桌面图标和应用绑定，卸载应用后系统会同时自动删除图标
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);

        mContext.sendBroadcast(resultIntent);
    }



    //   创建图标 com.share.shortcut
    protected void createShortCut(){
        Intent shortcutIntent = new Intent();
        //设置点击快捷方式时启动的Activity,因为是从Lanucher中启动，所以包名类名要写全。
        shortcutIntent.setComponent(new ComponentName(this.getPackageName(), UI.shortCutTargetUI));

        Log.i(TAG, "createShortCut: "+getPackageName() );

        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS|Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent resultIntent = new Intent();
        //设置快捷方式图标
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(this, R.drawable.yuanbao));
        //启动的Intent
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        //设置快捷方式的名称
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, UI.shortCutName);
        resultIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        sendBroadcast(resultIntent);
    }



}
