package com.util.javassist;

import javassist.*;

import java.io.IOException;

public class HelloJavassist {

    public static void main(String[] args) {
        frozenClass();
    }

    public static void heeloJavassist(){
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("com.util.javassist.Rectangle");
            cc.setSuperclass(pool.get("com.util.javassist.Point"));
            byte [] bytecode = cc.toBytecode();
            System.out.println("bytecode = " + bytecode);
            Class clazz = cc.toClass();
            System.out.println("clazz = " + clazz);
            cc.writeFile();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void definitionClass(){
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("Points");
    }

    /**
     * 冻结class
     */
    public static void frozenClass(){
        ClassPool pool = ClassPool.getDefault();
        ClassPool.doPruning = true;
        try {
            CtClass cc = pool.get("com.util.javassist.Rectangle");
            //如果`ClassPool.doPruning`设置为`true`，则`CtClass`当Javassist冻结该对象时，Javassist会修剪对象中包含的数据结构
            cc.stopPruning(true);
            //暂时停止修剪和冻结
            cc.debugWriteFile();
            cc.freeze();
            cc.defrost();
            // OK since the class is not frozen.
            cc.setSuperclass(pool.get("com.util.javassist.Point"));
            //转换为类文件。 debugWriteFile 后 cc 类没有被修剪。
            cc.writeFile();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }

    }

    /**
     * 冻结class
     */
    public static void classPathConfig(){
        ClassPool pool = ClassPool.getDefault();
        try {
            //静态类不能使用this
//        pool.insertClassPath(new ClassClassPath(this.getClass()));
            pool.insertClassPath(new ClassClassPath(HelloJavassist.class));
            pool.insertClassPath("/usr/local/javalib") ;
            CtClass cc = pool.get("com.util.javassist.Rectangle");
            //http://www.javassist.org:80/java/”添加到类搜索路径中
            ClassPath cp = new URLClassPath("www.javassist.org",80,"/java/","org.javassist");
            pool.insertClassPath(cp);
            //如果`ClassPool.doPruning`设置为`true`，则`CtClass`当Javassist冻结该对象时，Javassist会修剪对象中包含的数据结构
            cc.stopPruning(true);
            //暂时停止修剪和冻结
            cc.debugWriteFile();
            cc.freeze();
            cc.defrost();
            // OK since the class is not frozen.
            cc.setSuperclass(pool.get("com.util.javassist.Point"));
            //转换为类文件。 debugWriteFile 后 cc 类没有被修剪。
            cc.writeFile();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }

    }
}
