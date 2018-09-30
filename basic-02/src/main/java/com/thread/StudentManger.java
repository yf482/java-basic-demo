package com.thread;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 思路：
 * 1.学生有多个对象，并且信息较多，
 * 可以封装成一个对象类来存放信息，通过get、set来获取和设置
 * 2.涉及到的功能较多采用多个方法独立封装来做
 * 具体分为：
 * 录入方法，输入信息解析方法，排序方法，输出方法录入方法，输入信息解析方法，排序方法，输出方法
 */
public class StudentManger {
    private static int count = 0;
    private static Students[] stus = new Students[5];

    /**
     * 主方法入口
     */
    public static void main(String[] args) {
        inPut();
        dataSort(stus);
        outPut(joint(stus));
    }

    /**
     * 键盘录入
     */
    public static void inPut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生信息：");
        dataCut(scanner.next());
    }

    /**
     * 输出方法，用字符流写入文件
     *
     * @param str 要输出字符串
     */
    public static void outPut(String str) {
        FileWriter fWriter = null;
        try {
            fWriter = new FileWriter("./stu.txt");
            fWriter.write(str);
            fWriter.flush();
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将要对象数组拼接成字符串待输出
     *
     * @param stus 要输出的学生对象数组
     * @return 字符串
     */
    public static String joint(Students[] stus) {
        String reslut = "      学生成绩表：\r\n姓名\t学号\t语文\t数学\t英语\t总分\r\n";
        for (Students stu : stus) {
            reslut = reslut + "" + stu.getName() + "\t" + stu.getNumber() + "\t" + stu.getcScore() + "\t"
                    + stu.getmScore() + "\t" + stu.geteScore() + "\t" + stu.getTotalScore() + "\r\n";
        }
        return reslut;
    }

    /**
     * 输入字符串数据切割
     *
     * @param string
     */
    public static void dataCut(String string) {
        String[] data = string.split(",");
        if (data.length == 5) {
            Students stu = new Students();
            stu.setName(data[0]);
            stu.setNumber(Integer.parseInt(data[1]));
            stu.setcScore(Integer.parseInt(data[2]));
            stu.setmScore(Integer.parseInt(data[3]));
            stu.seteScore(Integer.parseInt(data[4]));
            stus[count] = stu;
            count++;
            if (count < 5) {
                inPut();
            }
        } else {
            System.out.println("输入格式有误，请按照：‘姓名，学号，语文，数学，英语’格式对应输入");
            inPut();
        }
    }

    /**
     * 把学生数组按照总分高低进行排序
     *
     * @param stus 传入的学生数组
     */
    public static void dataSort(Students[] stus) {
        Students temp;// 记录临时中间值
        for (int i = 0; i < stus.length; i++) {
            for (int j = i; j < stus.length; j++) {
                if (stus[i].getTotalScore() < stus[j].getTotalScore()) {
                    // 交换两元素的位置
                    temp = stus[i];
                    stus[i] = stus[j];
                    stus[j] = temp;
                }
            }
        }
    }

}
