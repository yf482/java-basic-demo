package com.io;

import java.io.*;

public class FileInAOutPutDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		copyTxt();

//		copyImg();
        copyMp3();
    }

    public static void copyTxt() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("e:\\d.txt");
            fos = new FileOutputStream("e:\\ddd.txt");
            int len = 0;
            //window 下 换行是\t\n两个字符
//		byte[] bt = new byte[fis.available()];//直接将可用的字节装进去，换行和空格字符计算方法
//		System.out.println(fis.available());
            byte[] bt = new byte[1024];//1k
            while ((len = fis.read(bt)) != -1) {
                System.out.println(new String(bt));
                fos.write(bt);

            }


        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }


        }

    }

    //copy img格式文件
    public static void copyImg() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("e:\\webForward.jpg");
            fos = new FileOutputStream("e:\\webForward2.jpg");
            int len = 0;
            //window 下 换行是\t\n两个字符
//		byte[] bt = new byte[fis.available()];//直接将可用的字节装进去，换行和空格字符计算方法
//		System.out.println(fis.available());
            byte[] bt = new byte[1024];//1k
            while ((len = fis.read(bt)) != -1) {
//			System.out.println(new String(bt));
                fos.write(bt);

            }


        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }


        }

    }

    public static void copyMp3() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream("e:\\初雪.mp3"));
            bos = new BufferedOutputStream(new FileOutputStream("e:\\初雪2.mp3"));

            int len = 0;
            byte[] bt = new byte[1024];
            //len=bis.read();对byte数据进行提升int
            while ((len = bis.read()) != -1) {
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
                    bis.close();
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
