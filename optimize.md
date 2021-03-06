

[Android 性能优化](http://rayleeya.iteye.com/blog/1961005)

[Android性能调优](http://www.trinea.cn/android/android-performance-demo/)

[Android性能优化典范](http://hukai.me/android-performance-patterns/)

[性能优化视频](https://www.youtube.com/playlist?list=PLWz5rJ2EKKc9CBxr3BVjPTPoDPLdPIFCE)

[Android性能优化案例研究](http://www.importnew.com/4065.html)

[OOM优化](http://rayleeya.iteye.com/blog/1956059)

[Android性能优化案例研究](http://codingnow.cn/android/1378.html)


[[Android] 内存泄漏调试经验分享 (一)](http://rayleeya.iteye.com/blog/727074)

### 卡顿优化点

* 1、图片加载框架线程优先级降低，减少对主线程CPU时间片的抢占
* 2、减少布局过度绘制，降低GPU绘制资源消耗
* 3、优化所有推荐集布局，减少布局深度，减少inflate时候遍历xml树的时间。
* 4、优化列表getView耗时操作，优化列表加载速度
* 5、优化搜索栏滚动字幕，每页减少50个TextView，减少不必要的测量布局和绘制。
* 6、优化首页ViewPager，去掉不可见tab页面的layout、measure。


开发过程关于卡顿的注意事项

* 1、布局时候注意减少布局层次。 Android布局采用XML树方式，每多一层，树的深度加一，inflate遍历时间会成倍增加，同时layout、measure、draw的时间也会相应增加。性能极致追求的做法是使用代码代替xml进行布局，可免去JAVA inflate 反射XML布局文件的时间。
* 2、减少布局的过度绘制。每多一层过度绘制，会多浪费一分GPU绘制资源，增加当前帧的绘制时间
* 3、注意子线程的数量和优先级管理。子线程虽然不会直接的阻塞UI，但是过多的子线程，特别是和UI线程相同优先级的线程，会不断抢占主线程的CPU时间片，造成主线程任务完成不及时，间接造成卡顿。
* 4、ListView getView减少耗时操作。在ListView getView做耗时的操作会直接ListView item的渲染速度，从而影响列表滑动卡顿。如当前PP各种复杂的推荐集，大大的增加列表项渲染时间，造成卡顿。
* 5、尽量维持最少的View个数。没多一个View，父布局在刷新绘制的时候，会多做一分测量、布局、绘制操作。
* 6、谨慎使用透明度动画。透明度动画绘制时候，会创建一个额外的Buffer，并且需要双倍的填充速度，是很耗性能的。
* 7、善用硬件加速。在一些动画效果很频繁的View，可以适当开启硬件加速加快布局渲染速度。
* 8、使用Animator替换Animation。Animator只会绘制当前View，Animation会将parent在内的所有子View都重绘。同一个View有多个Animator，可以使用PropertyValueHolder来合并一些重绘操作。
* 9、ViewPager使用注意页面回收和子页渲染。ViewPager本质上就是一个ViewGroup，当前页面的任务引起ViewGroup重绘的操作，都会引起其他所有子页面的绘制。如果每个子页面很复杂很庞大，会带来大量的卡顿。