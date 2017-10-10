package com.io;

import java.io.*;
import java.util.*;


public class SequenceInputStreamDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
//			testSequence();
//			splitFile();
            merge();
        } catch (IOException e) {

            throw new RuntimeException();
        }

    }

    /**
     * 合并文件  用SequenceInputStream
     *
     * @throws IOException
     */
    public static void testSequence() throws IOException {
        Vector<FileInputStream> vt = new Vector<FileInputStream>();
        vt.add(new FileInputStream("e:\\1.txt"));
        vt.add(new FileInputStream("e:\\2.txt"));
        vt.add(new FileInputStream("e:\\3.txt"));
        Enumeration<FileInputStream> enume = vt.elements();

        SequenceInputStream sis = new SequenceInputStream(enume);

        File file = new File("e:\\4.txt");
        if (file.exists())
            file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
//			System.out.println(String.valueOf(buf));
            fos.write(buf, 0, len);
        }

        fos.close();
        sis.close();


    }

    /**
     * 分割文件
     *
     * @throws IOException
     */
    public static void splitFile() throws IOException {

        FileInputStream fis = new FileInputStream("e:\\dd.mp3");

        FileOutputStream fos = null;

        byte[] buf = new byte[1024 * 1024 * 2];//2M
        int len = 0;
        int count = 1;

        while ((len = fis.read(buf)) != -1) {
            fos = new FileOutputStream("e:\\" + (count++) + ".part");
            fos.write(buf, 0, len);
        }

        fis.close();
        fos.close();

    }

    /**
     * 合并mp3文件
     *
     * @throws IOException
     */
    public static void merge() throws IOException {

        List<FileInputStream> al = new ArrayList<FileInputStream>();

        for (int i = 1; i <= 3; i++) {
            al.add(new FileInputStream("e:\\" + i + ".part"));
        }

        final Iterator<FileInputStream> it = al.iterator();

        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {

            @Override
            public FileInputStream nextElement() {
                return it.next();
            }

            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }
        };

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("e:\\mp.mp3");

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();


    }
}