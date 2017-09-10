package jvm.performance;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "TestServlet" ,asyncSupported = true,description = "TestServlet",urlPatterns = "/Test")
public class TestServlet extends HttpServlet {
    private static int count = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 测试串行垃圾回收期
         * 1668 197
         * -XX:+PrintGCDetails -Xmx32M -Xms128M -XX:+HeapDumpOnOutOfMemoryError -XX:+UseSerialGC -XX:PermSize=32M
         *
         * -XX:+PrintGCDetails -Xmx512M -Xms128M -XX:+HeapDumpOnOutOfMemoryError -XX:+UseSerialGC -XX:PermSize=32M -Xloggc:d:/gc.log
         *
         * -XX:+UseParNewGC
         * 并行垃圾处理会提高性能  提高吞吐量
         * -XX:+UseParallelGC -XX:+UseParallelOldGC -XX:ParallelGCThreads=8
         * 测试CMS回收器  关注不是吞吐量
         * -XX:+UseConcMarkSweepGC
         * -XX:ConcGCThreads=8
         *
         */
//        synchronized (this){
//        }
        System.out.println("count = " + count++);

        byte[] data = new byte[1024*1024];
        response.setContentType("text/palin");
        response.getWriter().write("nihao");

    }
}

