package com.share.shortcut;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      传统方式创建快捷方式
        findViewById(R.id.oldstyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipAnotherActivity(MainActivity.this,OldShortCutActivity.class);
            }
        });

//      Android7.1创建快捷方式
        findViewById(R.id.newstyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipAnotherActivity(MainActivity.this,ShortCut7_0Activity.class);
            }
        });

//      Android8.0创建快捷方式
        findViewById(R.id.morenewstyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipAnotherActivity(MainActivity.this,ShortCut8_0Activity.class);
            }
        });


        findViewById(R.id.target).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipAnotherActivity(MainActivity.this,TargetActivity.class);
            }
        });

    }



}
