package com.sundaything.mypluginapplication;

import android.app.Application;
import android.content.Context;

/**
 * @Title: MyPluginApplication
 * @Package com.sundaything.mypluginapplication
 * @Description:
 * @Author Y
 * @Date 16/8/15 16:47
 */
public class TestApplication extends Application {
    private static TestApplication sInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sInstance = this;
        PluginManager.getInstance().loadPluginApk("plugin.apk");
    }

    public static TestApplication getInstance(){
        return sInstance;
    }
}
