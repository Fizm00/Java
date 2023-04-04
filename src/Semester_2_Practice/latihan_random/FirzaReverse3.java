package Semester_2_Practice;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.ArrayList;

public class FirzaReverse3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(8);
        list.add(19);
        list.add(42);
        list.add(7);
        list.add(26);
        list.add(19);
        list.add(-8);
        list.add(193);
        list.add(204);
        list.add(6);
        list.add(-4);
        System.out.println("Sebelum reverse3: " + list);
        reverse3(list);
        System.out.println("Sesudah reverse3: " + list);
    }
    
    public static void reverse3(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 2; i += 3) {
            int temp = list.get(i);
            list.set(i, list.get(i + 2));
            list.set(i + 2, temp);
        }
    }
}

/*
 * output
 * Sebelum reverse3: [3, 8, 19, 42, 7, 26, 19, -8, 193, 204, 6, -4]
 * Sesudah reverse3: [19, 8, 3, 26, 7, 42, 193, -8, 19, -4, 6, 204]
 */