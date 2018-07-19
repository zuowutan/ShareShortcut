package com.share.shortcut;

import android.os.Bundle;
import android.view.View;


/**
 * 目标Activity
 */
public class TargetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);


        findViewById(R.id.goback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackMainActivity(TargetActivity.this);
            }
        });
    }



}
