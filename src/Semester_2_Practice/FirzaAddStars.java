package Semester_2_Practice;

//NAMA : FIRZA HIMAWAN
//NO   : 22537144003

import java.util.ArrayList;

public class FirzaAddStars {
    public static void addStars(ArrayList<String> list) {
        for (int i = 1; i < list.size(); i += 2) {
            list.add(i, "*");
        }
        list.add("*");
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("the");
        list.add("quick");
        list.add("brown");
        list.add("fox");

        addStars(list);

        System.out.println(list);
    }
}

/*
 * Output yang dikeluarkan dari program diatas adalah:
 * [the, *, quick, *, brown, *, fox, *]
 */