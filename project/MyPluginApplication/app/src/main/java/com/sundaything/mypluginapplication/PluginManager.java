package com.sundaything.mypluginapplication;

import com.sundaything.mylibrary.TestInterface;

/**
 * @Title: MyPluginApplication
 * @Package com.sundaything.mypluginapplication
 * @Description:
 * @Author Y
 * @Date 16/8/15 16:51
 */
public class PluginManager {

    private static PluginManager sInstance;
    private PluginLoader mPluginLoader;

    private PluginManager(){

    }

    public static PluginManager getInstance(){
        if (sInstance == null){
            synchronized (PluginManager.class){
                if (sInstance == null)
                    sInstance = new PluginManager();
            }
        }
        return sInstance;
    }

    private PluginLoader getPluginLoader(){
        if (mPluginLoader == null){
            mPluginLoader = new PluginLoader();
        }
        return mPluginLoader;
    }

    public void loadPluginApk(String pluginName){
        getPluginLoader().loadPluginApk(pluginName);
    }

    public TestInterface createPluginInstance(){
        if (mPluginLoader == null){
            return null;
        }
        TestInterface testInterface = (TestInterface) mPluginLoader.newInstance("com.sundaything.plugin.TestUtil");
        return testInterface;
    }

}
