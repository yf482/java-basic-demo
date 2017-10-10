package com.exception;
/*
 * 题目：已知User类，该类有name（String类型）和age（int类型）两个属性，
 * 请编写代码实现给ArrayList<User>排序，要求按照User对象的age的倒序排序。
上传代码的时候将运算结果截图一起提交。
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Test {
 public static void main(String[] args) {
  //初始化list<User>
  User u1 = new User("zhangsan", 21);
  User u2 = new User("lisi", 12);
  User u3 = new User("wangwu", 11);
  User u4 = new User("xiaoli", 29);
  List<User> userList = new ArrayList<User>();
  userList.add(u1);
  userList.add(u2);
  userList.add(u3);
  userList.add(u4);
  System.out.println("按照年齡倒序排序：");
  //使用Collections.sort方法对list<User>进行排序
  Collections.sort(userList, new SortByAge());
  //for增强语句 打印user内容
  for (User user : userList) {
   System.out.println(user.getName() + " --- " + user.getAge());
  }
 }
}
//构造比较器
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
//user类
class User{
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
 public User(String name,int age) {
  this.age = age;
  this.name = name;
 }
}
