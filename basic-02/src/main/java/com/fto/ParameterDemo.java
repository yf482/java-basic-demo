package com.fto;

public class ParameterDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a = 1;
        add(a);
        Koo koo = new Koo();
        add(koo);
        //打印ParameterDemo 中成员变量a的值  和打印Koo对象koo中a的值
        System.out.println(a + "," + koo.a);
        //打印Koo对象的引用值
        System.out.println(koo);

    }

    //方法功能：使koo中a的值增加1即koo.a=koo.a+1;
    public static int add(Koo koo) {
        Koo k = koo;
        k.a++;
        return koo.a;
    }

    //这里当a=1传进来时候  注意分辨两个a的谁是成员变量 谁是形式参数  这里a=this.a;
    public static int add(int a) {
        a++;//增加的是形参中的a  本类中的a值不变
        return a;
    }

}

class Koo {
    int a = 1;
}
