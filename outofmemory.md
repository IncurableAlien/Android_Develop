内存泄露场景

1、注册了监听器，忘了反过注册；
>销毁时反注册

2、内部类，匿名内部类；
>静态内部类

3、WebView	
>不要在xml中声明，销毁时移除所有的view，直接将weview相关的放在一个进程中，退出时直接杀死进程

[参考链接](https://medium.com/freenet-engineering/memory-leaks-in-android-identify-treat-and-avoid-d0b1233acc8#.bnwtaamwh)


内存泄露检测工具
[LeakCanary](http://www.jianshu.com/p/e9891d7512ff)

[Android内存分析命令](http://gityuan.com/2016/01/02/memory-analysis-command/)

[Android有效解决加载大图片时内存溢出的问题](http://www.cnblogs.com/wanqieddy/archive/2011/11/25/2263381.html)

[Android -> 如何避免Handler引起内存泄露](http://blog.csdn.net/feelang/article/details/39059705)

[Android - 利用LeakCanary检测内存泄露](http://cashow.github.io/android-detect-out-of-memory-with-leakcanary.html)


[内存泄露从入门到精通三部曲之基础知识篇](http://mp.weixin.qq.com/s?__biz=MzA3NTYzODYzMg==&mid=400674207&idx=1&sn=a9580ca0dffc62a6d7dbb8fd3d7a2ef1&scene=0&key=b410d3164f5f798e3f4b6de393face7f291ae1d5d6ce312646e1e72ba2b6849e52d3ef5d2d0e4e8579cc7841aac8b439&ascene=0&uin=MTYzMjY2MTE1&devicetype=iMac+MacBookPro10%2C1+OSX+OSX+10.11.1+build(15B42)&version=11020201&pass_ticket=hgYTL4MW7%2FI9mnat%2BT9S2RRS0IkFfm6yOLSy%2F4bguL4%3D)


[Android 开发绕不过的坑：你的 Bitmap 究竟占多大内存？](http://bugly.qq.com/bbs/forum.php?mod=viewthread&tid=498#rd)

[避免Android中Context引起的内存泄露](http://blog.csdn.net/boyupeng/article/details/46503221)

[腾讯](http://mp.weixin.qq.com/s?__biz=MzAxMzYyNDkyNA==&mid=2651332083&idx=1&sn=d5a1b24736d6f14ff24dfecf15e397a9&scene=0#wechat_redirect)

[内存分析命令](http://gityuan.com/2016/01/02/memory-analysis-command/)