package com.day03;

public class SwitchDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int x = 2;
        char ch = '+';

        switch (x) {
            case 2:
                System.out.println("a");
                break;
            case 7:
                System.out.println("b");
                break;
            case 6:
                System.out.println("c");
                break;
            case 3:
                System.out.println("d");
                break;
            default:
                System.out.println("e");
                break;
        }

        int a = 2;
        int b = 3;
        switch (ch) {
            case '-':
                System.out.println(a - b);
                break;
            case '+':
                System.out.println(a + b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("e");
                break;
        }
        int y = 5;
        switch (y) {
            case 3:
            case 4:
            case 5:
                System.out.println(y + "�´���");
                break;
            default:
                System.out.println("none");
                break;
        }

    }

}
