package com.sundaything.plugin;

import com.sundaything.mylibrary.TestInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: MyPluginApplication
 * @Package com.sundaything.plugin
 * @Description:
 * @Author Y
 * @Date 16/8/15 16:15
 */
public class TestUtil implements TestInterface {
    /**
     * 将时间转换成日期
     * @param dateFormat 日期格式
     * @param timeStamp 时间戳 单位为ms
     * @return
     */
    @Override
    public String getDateFromTimeStamp(String dateFormat, long timeStamp) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        Date date = new Date(timeStamp);
        return format.format(date);
    }

    @Override
    public String getTestString() {
        return "你好 plugin";
    }

    @Override
    public int getTextInt() {
        return 10;
    }

    @Override
    public double getDouble() {
        return 1000.00;
    }


}
