package com.sundaything.mypluginapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.sundaything.mylibrary.TestInterface;

public class MainActivity extends AppCompatActivity {

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClassLoader classLoader = getClassLoader();
        if (classLoader != null){
            Log.i("YZB", "[onCreate()] classLoader " + i + " : " + classLoader.toString());
            while (classLoader != null) {
                classLoader = classLoader.getParent();
                i++;
                Log.i("YZB", "[onCreate()] classLoader " + i + " :" + (classLoader == null ? "" : classLoader.toString()));
            }
        }

        TextView textView = (TextView) findViewById(R.id.hello);
        TestInterface testInterface = PluginManager.getInstance().createPluginInstance();
        if (testInterface != null) {
            textView.setText(testInterface.getDateFromTimeStamp("yyyy-MM-dd", System.currentTimeMillis()) + testInterface.getTestString() + testInterface.getTextInt() + testInterface.getDouble());
        } else {
            Log.i("YZB", "testInterface == null");
        }
    }
}
