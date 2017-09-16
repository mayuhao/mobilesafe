package com.airzj.mobilesafe.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.airzj.mobilesafe.BuildConfig;
import com.airzj.mobilesafe.R;


public class SplashActivity extends AppCompatActivity {
    private static final int ENTER_HOME = 100;
    private TextView tv_version_name;

    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case ENTER_HOME:
                    enterHome();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //初始化UI
        initUI();
        //初始化数据
        initData();
    }

    private void initData() {
        //显示版本名称
        String showtitle="当前版本： "+getVersionName();
        tv_version_name.setText(showtitle);
        //检测新版本，提示更新
        //获取本地版本号
        int mVersioncode = getVersionCode();
        //获取服务器版本号 （暂时略 返回jason）
        checkVersion();



    }

    private void checkVersion() {
        new Thread(){
            public void run(){
                Message msg = new Message().obtain();

                msg.what= ENTER_HOME;
                try {
                    Thread.sleep(6000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mHandler.sendMessage(msg);
            }
        }.start();
    }

    //进入主界面
    private void enterHome() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);

        finish();

    }

    private int getVersionCode(){
        return BuildConfig.VERSION_CODE;
    }


    private String getVersionName() {
        //获取应用版本名
        //AS与eclipse获取方式不同
        return BuildConfig.VERSION_NAME;

    }

    private void initUI() {
        tv_version_name = (TextView) findViewById(R.id.tv_version_name);
    }
}
