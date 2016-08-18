package com.sundaything.mylibrary;

/**
 * @Title: MyPluginApplication
 * @Package com.sundaything.mylibrary
 * @Description:
 * @Author Y
 * @Date 16/8/15 15:58
 */
public interface TestInterface {

    /**
     * 定义方法: 将时间戳转换成日期
     * @param dateFormat    日期格式
     * @param timeStamp     时间戳,单位为ms
     */
    String getDateFromTimeStamp(String dateFormat, long timeStamp);

    /**
     * 获取测试字符串
     * @return
     */
    String getTestString();

    /**
     * 获取Int
     * @return
     */
    int getTextInt();

    double getDouble();

}
