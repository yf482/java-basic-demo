package com.basic;

import org.junit.Test;

import java.io.IOException;

public class CmdDemo {

    @Test
    public void test1() {
        //获取运行时
        Runtime rt = Runtime.getRuntime();
        //获取进程
        Process p = null;
        try {
//			p = rt.exec("cmd.exe /c shutdown -a");
            p = rt.exec("cmd.exe /c notepad");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /**
         cmd /c dir 是执行完dir命令后关闭命令窗口。
         cmd /k dir 是执行完dir命令后不关闭命令窗口。
         cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。
         cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭。*/
        System.out.println(p.toString());
    }
}
