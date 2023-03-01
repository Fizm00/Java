package Semester_2_Practice;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.ArrayList;

public class FirzaIntersect {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(4);
        list1.add(8);
        list1.add(9);
        list1.add(11);
        list1.add(15);
        list1.add(17);
        list1.add(28);
        list1.add(41);
        list1.add(59);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(7);
        list2.add(11);
        list2.add(17);
        list2.add(19);
        list2.add(20);
        list2.add(23);
        list2.add(28);
        list2.add(37);
        list2.add(59);
        list2.add(81);
        System.out.println("list 1 Sebelum=" +list1);
        System.out.println("list 2 Sebelum=" +list2);

        ArrayList<Integer> result = intersect(list1, list2);

        System.out.println("setelah=" +result);
    }

    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).equals(list2.get(j))) {
                result.add(list1.get(i));
                i++;
                j++;
            } else if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}

/*
 * output : 
 * list 1 Sebelum=[1, 4, 8, 9, 11, 15, 17, 28, 41, 59]
 * list 2 Sebelum=[4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81]
 * setelah=[4, 11, 17, 28, 59]
 */