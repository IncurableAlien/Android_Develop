package com.sundaything.mypluginapplication;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import dalvik.system.DexClassLoader;

/**
 * @Title: MyPluginApplication
 * @Package com.sundaything.mypluginapplication
 * @Description:
 * @Author Y
 * @Date 16/8/15 16:39
 */
public class PluginLoader {

    private DexClassLoader mDexClassLoader;

    public void loadPluginApk(String pluginName){
        mDexClassLoader = createDexClassLoader(pluginName);
    }

    private DexClassLoader createDexClassLoader(String pluginName) {
        boolean isSaved = savePluginApkToStorege(pluginName);
        if (!isSaved){
            return null;
        }

        DexClassLoader dexClassLoader = null;
        String apkPath = getPluginApkDirectory() + pluginName;
        File dexOutputDir = TestApplication.getInstance().getDir("dex", 0);
        String dexOutputDirPath = dexOutputDir.getAbsolutePath();
        Log.i("PluginLoad", " apkPath = " + apkPath + " dexOutPath = " + dexOutputDirPath);

        ClassLoader classLoader = TestApplication.getInstance().getClassLoader();
        dexClassLoader = new DexClassLoader(apkPath, dexOutputDirPath, null, classLoader);
        return dexClassLoader;
    }

    public Object newInstance(String className){
        if (mDexClassLoader == null)
            return null;
        try {
            Class<?> clazz = mDexClassLoader.loadClass(className);
            Object instance = clazz.newInstance();
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPluginApkDirectory(){
        return TestApplication.getInstance().getDir("apk", 0).getAbsolutePath();
    }

    private boolean savePluginApkToStorege(String pluginName){
        String pluginApkPath = getPluginApkDirectory() + pluginName;
        File pluginApkFile = new File(pluginApkPath);
        if (pluginApkFile.exists()){
            boolean isDelete = pluginApkFile.delete();
            Log.i("YZB" , "isdelete" + isDelete);
        }

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try {
            InputStream stream = TestApplication.getInstance().getAssets().open("plugin/" + pluginName);
            inputStream = new BufferedInputStream(stream);
            outputStream = new BufferedOutputStream(new FileOutputStream(pluginApkPath));

            final int BUF_SIZE = 4096;
            byte[] buf = new byte[BUF_SIZE];
            while (true){
                int readCount = inputStream.read(buf, 0, BUF_SIZE);
                if (readCount == -1){
                    break;
                }

                outputStream.write(buf, 0, readCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }
}
