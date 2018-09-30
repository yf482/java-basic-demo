package com.enumeration;

public enum EnumDemo2 {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7) {


    };
    private int value;

    EnumDemo2(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        System.out.println(EnumDemo2.WED.getValue());
    }
}
