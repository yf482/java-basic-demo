package com.collection;

public class NineTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int count = 0;
//		Pattern p =Pattern.compile("{9}?{9}?{9}?");
        for (int i = 0; i < 1000; i++) {
            String s = Integer.toString(i);
            if (s.length() == 1 && s.contains("9")) {
                count++;
                System.out.println(s);
            }
            if (s.length() == 2 && s.contains("9")) {
                count++;
                System.out.println(s);

                if (s.equals("99")) ;
                {
                    count++;
                    System.out.println(s);
                }

            }
            if (s.length() == 3 && s.contains("9")) {
                count++;
                System.out.println(s);
                if (s.indexOf('9') == 0 && s.lastIndexOf('9') == 1 && !(s.equals("999"))) {
                    count++;
                    System.out.println(s);
                }
                if (s.indexOf('9') == 0 && s.lastIndexOf('9') == 2 && !(s.equals("999"))) {
                    count++;
                    System.out.println(s);
                }
                if (s.indexOf('9') == 1 && s.lastIndexOf('9') == 2 && !(s.equals("999"))) {
                    count++;
                    System.out.println(s);
                }
                if (s.equals("999")) {
                    count += 2;
                    System.out.println(s);
                    System.out.println(s);
                }
            }
        }
        System.out.println(count);
    }

}
