package com.day17_18;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemIn_OutDemo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//		testIn();
//		testOut();
//		testReader();
//		testCopy();
        testException();
    }

    public static void testIn() throws IOException {
        InputStream in = System.in;
        int ch = 0;
        while ((ch = in.read()) != -1) {
            //输出a\r\n
            System.out.println(ch);
        }
    }

    /**
     * 控制台输出over结束进程
     *
     * @throws IOException
     */
    public static void testOut() throws IOException {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int ch = in.read();
            if (ch == '\r')
                continue;
            if (ch == '\n') {
                String s = sb.toString();
                if ("over".equals(s)) {
                    break;
                }
                System.out.println(s.toUpperCase());
                sb.delete(0, sb.length());
                continue;
            }
            sb.append((char) ch);
        }

    }

    /**
     * BufferedReader
     *
     * @throws IOException
     */
    public static void testReader() throws IOException {
        //获取系统输入流
//		InputStream in =System.in;
//		//将字节流转换为字符流
//		InputStreamReader isr =new InputStreamReader(in);
//		//对字符流进行包装增强操作
//		BufferedReader  bufr =new BufferedReader(isr);
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

//		OutputStream os =System.out;
//		OutputStreamWriter osw = new OutputStreamWriter(os);
//		BufferedWriter bufw =new BufferedWriter(osw);
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = null;
        while ((str = bufr.readLine()) != null) {
            //输出a\r\n
            if ("over".equals(str))
                break;
//			System.out.println(str.toUpperCase());
            bufw.write(str.toUpperCase());
            bufw.flush();
        }
        bufr.close();
        bufw.close();
    }

    /**
     * 控制台写入文件txt
     *
     * @throws IOException
     */
    public static void testCopy() throws IOException {

        System.setIn(new FileInputStream("e:\\d.txt"));
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //可以制定码表进行文件写入，控制台默认gbk
//		BufferedWriter bufw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream("e:\\writer.txt")));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();

        }

        bufw.close();

    }

    public static void testException() throws IOException {
        PrintStream ps = new PrintStream("e:\\exceptionIO.txt");
        try {
            int[] arr = new int[2];
            System.out.println(arr[3]);

        } catch (Exception e) {
            Date d = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String s = sdf.format(d);
            System.out.println(s);
            ps.println(s);
            //
            e.printStackTrace(ps);
        }
        ps.close();
    }
}
