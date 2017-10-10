package com.day17_18;

import java.io.*;

public class MyBufferedInputStreamDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();


        copyMp3();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public static void copyMp3() {
        MyBufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new MyBufferedInputStream(new FileInputStream("e:\\初雪.mp3"));
            bos = new BufferedOutputStream(new FileOutputStream("e:\\初雪2.mp3"));

            int len = 0;
            byte[] bt = new byte[1024];
            //len=bis.read();对byte数据进行提升int
            while ((len = bis.myRead()) != -1) {
                {
                    //write(len)对int进行降低为byte
                    bos.write(len);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bis != null) {
                    bis.myClose();
                }
            } catch (IOException e2) {
            }

            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e2) {
            }

        }

    }
}


class MyBufferedInputStream {
    private InputStream in;
    private byte[] buf = new byte[1024 * 4];
    private int pos = 0, count = 0;


    MyBufferedInputStream(InputStream in) throws IOException {
        this.in = in;
    }

    //一次读入一个字节，从缓冲区（字节数组）获取
    public int myRead() throws IOException {
        //从inputStream取出放到buff字节数组中
        if (count == 0) {
            count = in.read(buf);
            if (count < -1)
                return -1;
            pos = 0;
            byte b = buf[pos];
            //取完的时候就是count=0
            count--;
            pos++;
            return b & 0xff;
        } else if (count > 0) {
            byte b = buf[pos];
            count--;
            pos++;
            return b & 255;
        }
        return -1;


    }

    public void myClose() throws IOException {
        in.close();
    }
}


/*
byte
00000001
11111110
00000001+
11111111 =-1

提升
//int :11111111 11111111 11111111 11111111 =-1
 	   00000000 00000000 00000000 11111111&
 	  =00000000 00000000 00000000 11111111	255=0xff
 */
