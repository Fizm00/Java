package Semester_2_Practice;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.ArrayList;

public class FirzaSwitchPairs {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("four");
        list1.add("score");
        list1.add("and");
        list1.add("seven");
        list1.add("years");
        list1.add("ago");
        System.out.println("Sebelum di switch: " + list1);
        switchPairs(list1);
        System.out.println("Sesudah di switch: " + list1);

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("to");
        list2.add("be");
        list2.add("or");
        list2.add("not");
        list2.add("to");
        list2.add("be");
        list2.add("hamlet");
        System.out.println("Sebelum di switch: " + list2);
        switchPairs(list2);
        System.out.println("Sesudah di switch: " + list2);
    }

    public static void switchPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }
}

/*
 * output : 
 * Sebelum di switch: [four, score, and, seven, years, ago]
 * Sesudah di switch: [score, four, seven, and, ago, years]
 * Sebelum di switch: [to, be, or, not, to, be, hamlet]
 * Sesudah di switch: [be, to, not, or, be, to, hamlet]
 */