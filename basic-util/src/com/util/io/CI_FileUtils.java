package com.util.io;

import java.io.File;
import java.io.IOException;

public class CI_FileUtils {

    public static File checkFileExist(String filepath) throws IOException {
        File file = new File(filepath);
        if (!file.exists()) {// 判断文件的存在
            file.createNewFile();// 创建文件
        }
        return file;
    }

    public static File checkDiretoryExist(String filepath) {
        File file = new File(filepath);
        if (!file.exists() && !file.isDirectory()) {// 判断文件目录的存在
            System.out.println("文件夹不存在，并创建:" + filepath);
            file.mkdirs();
        }
        return file;
    }

    public static File createFileNotExist(String filepath) throws IOException {
        File file = new File(filepath);
        if (!file.exists()) {// 判断文件的存在
            file.createNewFile();// 创建文件
            System.out.println("文件不存在，创建文件成功！");
        }
        return file;
    }

    public static File mkdirDiretoryNotExist(String filepath) {
        File file = new File(filepath);
        if (!file.exists() && !file.isDirectory()) {// 判断文件目录的存在
            System.out.println("文件夹不存在，并创建:" + filepath);
            file.mkdirs();
        }
        return file;
    }

    public static File checkExist(String filepath) throws Exception {
        File file = new File(filepath);

        if (file.exists()) {// 判断文件目录的存在
            System.out.println("文件夹存在！");
            if (file.isDirectory()) {// 判断文件的存在性
                System.out.println("文件存在！");
            } else {
                file.createNewFile();// 创建文件
                System.out.println("文件不存在，创建文件成功！");
            }
        } else {
            System.out.println("文件夹不存在！");
            File file2 = new File(file.getParent());
            file2.mkdirs();
            System.out.println("创建文件夹成功！");
            if (file.isDirectory()) {
                System.out.println("文件存在！");
            } else {
                file.createNewFile();// 创建文件
                System.out.println("文件不存在，创建文件成功！");
            }
        }
        return file;
    }
}
