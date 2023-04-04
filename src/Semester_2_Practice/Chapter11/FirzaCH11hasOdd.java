package Semester_2_Practice.Chapter11;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.Set;

public class FirzaCH11hasOdd {
    public static boolean hasOdd(Set<Integer> set) {
        for (int i : set) {
            if (i % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3, 4, 5);
        Set<Integer> set2 = Set.of(2, 4, 6, 8);
        Set<Integer> set3 = Set.of(0, 2, 4, 6);
        Set<Integer> set4 = Set.of(14, 6, 37, 2, 19, 8);

        System.out.println(hasOdd(set1)); 
        System.out.println(hasOdd(set2)); 
        System.out.println(hasOdd(set3)); 
        System.out.println(hasOdd(set4)); 
    }
}

/*
 * Output:
 * 1, 2, 3, 4, 5 -> true
 * 2, 4, 6, 8 -> false
 * 0, 2, 4, 6 -> false
 * 14, 6, 37, 2, 19, 8 -> true
 */