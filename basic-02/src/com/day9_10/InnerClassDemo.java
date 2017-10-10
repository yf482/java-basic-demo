package com.day9_10;

/*
 * �ڲ�����ʹ���
 * 1.�ڲ�����Է����ⲿ��ĳ�Ա������˽��
 * ֮���Կ���ֱ�ӷ����ⲻ���еĳ�Ա������Ϊ�ڲ������һ���ⲿ������ã���ʽ���ⲿ����.this
 * 2.�ⲻ��Ҫ�����ڲ��࣬���뽨���ڲ������ 
 * ���ʸ�ʽ��1.���ڲ��ඨ�����ⲻ�۵ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ�������С�
 * ����ֱ�Ӽ����ڲ������
 * ��ʽ�� �ⲿ����.�ڲ�����   ������ = �ⲿ�����.�ڲ������
 * 
 * 2.���ڲ����ڳ�Աλ���ϾͿ����³�Ա���η������Ρ�����private���ڲ������ⲿ���н��з�װ��
 * static :�ڲ���;߱�static�����ԡ�ֻ��ֱ�ӷ����ⲿ���е�static ��Ա�������˷��ʾ��ޡ�
 * ���ⲿ�������У����ֱ�ӷ���static�ڲ���ķǾ�̬��Ա�أ���
 * new Outer.Inner.function();
 * ���ⲿ�������У����ֱ�ӷ���static�ڲ���ľ�̬��ԱԱ��
 * outer.Inner.function();
 * ע�⣺���ڲ����ж��徲̬��Ա�����ڲ��������staticde ���ⲿ���еľ�̬���������ڲ����ǣ��ڲ���Ҳ������staticd�ġ�
 * 
 * �����������ʱ��������ڲ�����������������ڲ�����������
 * ��Ϊ�ڲ�������ʹ���ⲿ��������ݡ�
 * class Body
 * {
 * 	private class Xinzhang
 * 	{
 * 
 * 	}
 * 
 * }
 * 
 * 
 * */
public class InnerClassDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Outer out = new Outer();
        out.method();

        Outer.Inner in = new Outer().new Inner();


    }


}

class Outer {
    private int x = 3;

    //�ڲ��� �������Ա  ��������privateȨ��
    class Inner {
        int x = 4;

        void function() {
            System.out.println("inner:x=" + x + Outer.this.x);

        }
    }

    void method() {
        Inner in = new Inner();
        in.function();
    }
}
