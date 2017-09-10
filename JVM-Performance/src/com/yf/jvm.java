package com.yf;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc jvm
 * @create 2017-09-09 23:52
 **/
public class jvm {


    public static void main(String[] args) {

        //-XX:+PrintGC -Xms5m -Xmx20m -XX:+UseSerialGC -XX:+PrintGCDetails
        //-verbose:gc -XX:+printGC 打印gc详情
        //-XX:+PrintGCTimeStamps 打印GC时间戳
        //-XX:+PrintCommandLineFlags

//        理解GC日志的含义：
//        例如下面这段日志：
//        [GC[DefNew: 4416K->0K(4928K), 0.0001897 secs] 4790K->374K(15872K), 0.0002232 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        上方日志的意思是说：这是一个新生代的GC。方括号内部的“4416K->0K(4928K)”含义是：“GC前该内存区域已使用容量->GC后该内存区域已使用容量（该内存区域总容量）”。而在方括号之外的“4790K->374K(15872K)”表示“GC前Java堆已使用容量->GC后Java堆已使用容量（Java堆总容量）”。
//        再往后看，“0.0001897 secs”表示该内存区域GC所占用的时间，单位是秒。
//
//        -Xloggc:log/gc.log

//        -XX:+PrintHeapAtGC  解释：每一次GC前和GC后，都打印堆信息。
//        -XX:+TraceClassLoading  解释：监控类的加载。
//        -XX:+PrintClassHistogram 解释：按下Ctrl+Break后，打印类的信息。
//        1、-Xmx –Xms：指定最大堆和最小堆
//        2、-Xmn、-XX:NewRatio、-XX:SurvivorRatio：
//
//　　　　设置新生代大小
//                -XX:NewRatio
//　　　　新生代（eden+2*s）和老年代（不包含永久区）的比值
//    　　　　例如：4，表示新生代:老年代=1:4，即新生代占整个堆的1/5
//                -XX:SurvivorRatio（幸存代）
//　　　　设置两个Survivor区和eden的比值
//    　　　　例如：8，表示两个Survivor:eden=2:8，即一个Survivor占年轻代的1/10

//        2、-Xmn、-XX:NewRatio、-XX:SurvivorRatio：
//        -Xmn
//　　　　设置新生代大小
//                -XX:NewRatio
//　　　　新生代（eden+2*s）和老年代（不包含永久区）的比值
//    　　　　例如：4，表示新生代:老年代=1:4，即新生代占整个堆的1/5
//                -XX:SurvivorRatio（幸存代）
//　　　　设置两个Survivor区和eden的比值
//    　　　　例如：8，表示两个Survivor:eden=2:8，即一个Survivor占年轻代的1/10
//
//        总结：
//（3）当参数设置为如下时：（设置新生代为7M，不大不小）
//        -Xmx20m -Xms20m –Xmn7m -XX:+PrintGCDetails
//　　进行了2次新生代GC
//　　s0 s1 太小，需要老年代担保
//
//      （4）当参数设置为如下时：（设置新生代为7M，不大不小；同时，增加幸存代大小）
//
//        -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
//        总结：
//        进行了至少3次新生代GC
//        s0 s1 增大
//
//       （5）当参数设置为如下时：
//
//        -Xmx20m -Xms20m -XX:NewRatio=1
//
//                -XX:SurvivorRatio=2 -XX:+PrintGCDetails
//        (6）当参数设置为如下时： 和上面的（5）相比，适当减小幸存代大小，这样的话，能够减少GC的次数
//
//        -Xmx20m -Xms20m -XX:NewRatio=1
//
//        -XX:SurvivorRatio=3 -XX:+PrintGCDetails
//
//        3、-XX:+HeapDumpOnOutOfMemoryError、-XX:+HeapDumpPath
//
//                -XX:+HeapDumpOnOutOfMemoryError
//　　　　OOM时导出堆到文件
//
//　　　　　　根据这个文件，我们可以看到系统dump时发生了什么。
//
//        -XX:+HeapDumpPath
//　　　　导出OOM的路径
//
//        例如我们设置如下的参数：
//
//        -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/a.dump
//        上方意思是说，现在给堆内存最多分配20M的空间。如果发生了OOM异常，那就把dump信息导出到d:/a.dump文件中。
//        4、-XX:OnOutOfMemoryError：
//
//        -XX:OnOutOfMemoryError
//　　　　在OOM时，执行一个脚本。
//
//　　　　　　可以在OOM时，发送邮件，甚至是重启程序。
//
//        例如我们设置如下的参数：
//
//        -XX:OnOutOfMemoryError=D:/tools/jdk1.7_40/bin/printstack.bat %p //p代表的是当前进程的pid
//        上方参数的意思是说，执行printstack.bat脚本，而这个脚本做的事情是：D:/tools/jdk1.7_40/bin/jstack -F %1 > D:/a.txt，即当程序OOM时，在D:/a.txt中将会生成线程的dump。
//
//        5、堆的分配参数总结：
//
//        根据实际事情调整新生代和幸存代的大小
//        官方推荐新生代占堆的3/8
//        幸存代占新生代的1/10
//        在OOM时，记得Dump出堆，确保可以排查现场问题

//        6、永久区分配参数：
//
//        -XX:PermSize  -XX:MaxPermSize
//　　　　设置永久区的初始空间和最大空间。也就是说，jvm启动时，永久区一开始就占用了PermSize大小的空间，如果空间还不够，可以继续扩展，但是不能超过MaxPermSize，否则会OOM。
//
//　　　　他们表示，一个系统可以容纳多少个类型
//
//        代码举例：
//
//        我们知道，使用CGLIB等库的时候，可能会产生大量的类，这些类，有可能撑爆永久区导致OOM。于是，我们运行下面这段代码：
//
//        for(int i=0;i<100000;i++){
//　　CglibBean bean = new CglibBean("geym.jvm.ch3.perm.bean"+i,new HashMap());
//        }
//        总结：
//
//　　如果堆空间没有用完也抛出了OOM，有可能是永久区导致的。
//
//　　　　堆空间实际占用非常少，但是永久区溢出 一样抛出OOM。
//
//        三、栈的分配参数：
//
//        1、Xss：
//
//        设置栈空间的大小。通常只有几百K
//
//　　决定了函数调用的深度
//
//　　每个线程都有独立的栈空间
//
//　　局部变量、参数 分配在栈上
//
//        注：栈空间是每个线程私有的区域。栈里面的主要内容是栈帧，而栈帧存放的是局部变量表，局部变量表的内容是：局部变量、参数。
//
//        我们来看下面这段代码：（没有出口的递归调用）
//        如果设置栈大小为128k：
//
//        -Xss128K
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory = " + maxMemory);
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory = " + freeMemory);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + totalMemory);

        //分配了1M
        byte[] b1 = new byte[1*1024*1024];

        long maxMemory2 = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory = " + maxMemory2);
        long freeMemory2 = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory = " + freeMemory2);
        long totalMemory2 = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + totalMemory2);

        //分配了4M
        byte[] b2 = new byte[4*1024*1024];

        long maxMemory3 = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory = " + maxMemory2);
        long freeMemory3 = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory = " + freeMemory2);
        long totalMemory3 = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + totalMemory3);

    }
}
