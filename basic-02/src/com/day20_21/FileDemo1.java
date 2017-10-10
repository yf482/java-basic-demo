package com.day20_21;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String path = "e:\\ddd";
//		testFile2();
//		listFile("e:\\ddd");
        listFile2(path, 0);
    }

    public static void testFile() {
        //将a.txt封装城File对象   文件夹也能封装成分割符
        File f1 = new File("c:\\a.txt");

        File f3 = new File("c:\\abc");
        File f4 = new File(f3, "c.txt");

        File f2 = new File("c:\\abc", "a.txt");
        //separator 系统默认分隔符

        File f5 = new File("C:" + File.separator + "b.txt");


    }

    /**
     * File 基本方法
     */
    public static void testFile2() {

        File f1 = new File("e:\\ddd");
        System.out.println(f1.canExecute());
        System.out.println(f1.canRead());
        System.out.println(f1.exists());
        System.out.println(f1.getPath());
        System.out.println(f1.getName());

        for (String s : f1.list()) {
            System.out.println(s);
        }

        //FilenameFilter
        String[] ss = f1.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".jpg"))
                    return true;
                return false;
            }
        });
        for (String s : ss) {
            System.out.println("Filter:" + s);
        }

    }
    //递归遍历文件目录

    public static void listFile(String path) {

//		File f1 = new File("e:\\ddd");
        File f1 = new File(path);
        System.out.println(f1.getPath());
        File[] ff = f1.listFiles();
        for (File f : ff) {
            System.out.println(f.getPath() + "::" + f.getName());

            if (f.isDirectory()) {
                listFile(f.getPath());
            }
        }

    }

    public static void listFile2(String path, int level) {

        //		File f1 = new File("e:\\ddd");

        File f1 = new File(path);
        System.out.println(f1.getPath());
        File[] ff = f1.listFiles();
        for (File f : ff) {
            System.out.println(getLevel(level) + f.getName());

            if (f.isDirectory()) {
                level++;
                listFile2(f.getPath(), level);
            }
        }

    }

    public static String getLevel(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int i = 0; i < level; i++) {
            sb.insert(0, "|   ");
        }

        return sb.toString();


    }


}
