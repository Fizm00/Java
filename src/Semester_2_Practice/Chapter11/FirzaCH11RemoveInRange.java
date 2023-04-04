package Semester_2_Practice.Chapter11;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirzaCH11RemoveInRange {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16));
        System.out.println("List sebelum: " + list);
        RemoveInRange.removeInRange(list, 0, 5, 13);
        System.out.println("List setelah dimodifikasi: " + list);
    }
    public class RemoveInRange {
        public static void removeInRange(List<Integer> list, int element, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                if (list.get(i) == element) {
                    list.remove(i);
                    endIndex--;
                    i--;
                }
            }
        }
    }
}


/*
 * Output:
 * List sebelum: [0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16]
 * List setelah dimodifikasi: [0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 16]
 */