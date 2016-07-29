# OKHttp 

一个开源框架的诞生解决什么样的问题？

使用场景是什么？

有什么优点和缺点？

技术选型上为何要用到这个？成本？风险？易用性？后期扩展和维护上？



"OkHttp是一款优秀的HTTP框架，它支持get请求和post请求，支持基于Http的文件上传和下载，支持加载图片，支持下载文件透明的GZIP压缩，支持响应缓存避免重复的网络请求，支持使用连接池来降低响应延迟问题。"



### 概览

"OkHttp是一款优秀的HTTP框架，它支持get请求和post请求，支持基于Http的文件上传和下载，支持加载图片，支持下载文件透明的GZIP压缩，支持响应缓存避免重复的网络请求，支持使用连接池来降低响应延迟问题。"



http是现在主流应用使用的网络请求方式, 用来交换数据和内容, 有效的使用HTTP可以使你的APP 变的更快和减少流量的使用

OkHttp 是一个很棒HTTP客户端:

- 支持SPDY, 可以合并多个到同一个主机的请求
-  使用连接池技术减少请求的延迟(如果SPDY是可用的话)
-  使用GZIP压缩减少传输的数据量
-  缓存响应避免重复的网络请求

当你的网络出现拥挤的时候,就是OKHttp 大显身手的时候, 它可以避免常见的网络问题,如果你的服务是部署在不同的IP上面的,如果第一个连接失败, OkHTtp会尝试其他的连接. 这个对现在IPv4+IPv6 中常见的把服务冗余部署在不同的数据中心上.  OkHttp 将使用现在TLS特性(SNI ALPN) 来初始化新的连接. 如果握手失败, 将切换到SLLv3

使用OkHttp很容易,   同时支持 异步阻塞请求和回调.

如果你使用OkHttp ,你不用重写你的代码,   okhttp-urlconnection模块实现了 java.net.HttpURLConnection 中的API,  okhttp-apache模块实现了HttpClient中的API。



[okHttp](https://gold.xitu.io/entry/5728441d128fe1006058b6b9)

[鸿洋](http://blog.csdn.net/lmj623565791/article/details/47911083)

[对OkHttp进行封装，实现了只查询缓存，网络请求失败自动查询本地缓存等功能](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1208/3760.html)

[Android Https相关完全解析 当OkHttp遇到Https](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0831/3393.html)

[OKHttp源码解析](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0326/2643.html)

[如何更高效地使用 OkHttp](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2016/0222/3988.html)

[Android OkHttp完全解析 是时候来了解OkHttp了](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0824/3355.html)

[OkHttp的使用简介及封装，实现更简洁的调用](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2016/0105/3831.html)

[OkHttp使用教程](http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0106/2275.html)

