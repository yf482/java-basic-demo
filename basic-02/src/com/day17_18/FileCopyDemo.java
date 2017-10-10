package com.day17_18;

import java.io.*;

public class FileCopyDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		copyFile();
        bufferDemo();
//		bufferCopyFile();
    }

    public static void copyFile() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("e:\\d.txt");
            //����true���ļ�������ӣ���Ȼ����ˢ�����ݣ�ԭ������ʧ
            fw = new FileWriter("e:\\dd.txt", true);

            int len = 0;
            char[] buf = new char[1024];
            while ((len = fr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));

                fw.write(buf);
            }
            //ˢ�»��浽�ļ���
            fw.flush();

        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            if (fr != null)
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
        }


    }

    /**
     *
     */
    public static void bufferDemo() {
        FileReader fr = null;

        BufferedReader bufr = null;

        MyBufferedReader mybufr = null;

        try {
            fr = new FileReader("e:\\d.txt");
            //Ϊ����ļ���ȡ�ٶȣ����绺�弼�����Ȱ����ݶ�����Ӧ��С���ڴ����棬��һ����д���ļ�
            bufr = new BufferedReader(fr);
            //readLine();����null������ļ�ĩβ

            //�Լ���bufferdReader()��
            mybufr = new MyBufferedReader(fr);

            String line = null;
//			while((line = bufr.readLine())!=null)
//			{
////				System.out.println(line);
//			}

            while ((line = mybufr.myLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            throw new RuntimeException();

        } finally {
            //�ر���Դ
            try {
                if (bufr != null)
                    bufr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufr != null)
                    mybufr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void bufferCopyFile() {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            fr = new FileReader("e:\\d.txt");
            fw = new FileWriter("e:\\dd.txt");

            //Ϊ����ļ���ȡ�ٶȣ����绺�弼�����Ȱ����ݶ�����Ӧ��С���ڴ����棬��һ����д���ļ�
            bufr = new BufferedReader(fr);
            bufw = new BufferedWriter(fw);
            //readLine();����null������ļ�ĩβ
            String line = null;
            while ((line = bufr.readLine()) != null) {
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }

        } catch (Exception e) {
            throw new RuntimeException();

        } finally {
            //�ر���Դ
            try {
                if (bufr != null)
                    bufr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bufw != null)
                    bufr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}

//ģ��bufferedReader���ܣ�
//����ʵ��һ��װ�����ģʽ����װ�࣬Ϊ�������ṩ��ǿ��Ĺ��ܣ�Ҳ�������չ��
class MyBufferedReader {
    FileReader fr;

    MyBufferedReader(FileReader fr) {
        this.fr = fr;
    }

    public String myLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch = 0;


        while ((ch = fr.read()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n')
                return sb.toString();
            sb.append((char) ch);

        }
        //���һ��û��\n����Ҫ����
        if (sb.length() != 0)
            return sb.toString();
        return null;
    }

    public void close() throws IOException {

        fr.close();

    }
}