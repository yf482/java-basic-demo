package com.day9_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class ExceptionDemo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void readFile3(String file) {
        BufferedReader reader = null;
        Connection conn = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            conn = DriverManager.getConnection("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
/*
 * 1.���쳣�Ƕ���˵�����ϸ�ĳ���ȷʵ������һʧ�������쳣���ܲ���
 * ��վ�ڳ���Ա�ĽǶ���˵����һ�������쳣ȴ���ֱܷ浽����ʲô����ġ���IO����JDBC
 * �����������һ��������ʵ����һ�������ʶ��
 * 2.����ϣ���������쳣ʱ�򾡿����ṩ�������Ϣ������������λ�á���������ԭ��ȡ��������ܸ�����Ľ�����⡣
 * �����Ǽ򵥵�e.printStackTrace();
 * 3.try blockд�ļ�̣���Ҫʲô������������������ܶԿ��ܷ����쳣��λ�ý���try catch  ������Ϊÿ���쳣��try catch 
 * 
 * 
 * */
 