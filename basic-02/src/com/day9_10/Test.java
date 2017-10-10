package com.day9_10;
/*
 * ��Ŀ����֪User�࣬������name��String���ͣ���age��int���ͣ��������ԣ�
 * ���д����ʵ�ָ�ArrayList<User>����Ҫ����User�����age�ĵ�������
�ϴ������ʱ����������ͼһ���ύ��
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //��ʼ��list<User>
        User u1 = new User("zhangsan", 21);
        User u2 = new User("lisi", 12);
        User u3 = new User("wangwu", 11);
        User u4 = new User("xiaoli", 29);
        List<User> userList = new ArrayList<User>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        System.out.println("�������g��������");
        //ʹ��Collections.sort������list<User>��������
        Collections.sort(userList, new SortByAge());
        //for��ǿ��� ��ӡuser����
        for (User user : userList) {
            System.out.println(user.getName() + " --- " + user.getAge());
        }
    }
}

//����Ƚ���
class SortByAge implements Comparator {
    public int compare(Object o1, Object o2) {
        User s1 = (User) o1;
        User s2 = (User) o2;
        if (s1.getAge() > s2.getAge())
            return -1;
        else if (s1.getAge() == s2.getAge()) {
            return 0;
        }
        return 1;
    }
}

//user��
class User {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
