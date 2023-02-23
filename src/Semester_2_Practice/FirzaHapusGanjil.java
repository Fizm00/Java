package Semester_2_Practice;

import java.util.ArrayList;

public class FirzaHapusGanjil {
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<Integer>();

        for (int i = 0; i <= 10; i++) {
            dataList.add(i);
        }

        System.out.println("Sebelum dihapus: " + dataList);

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) % 2 != 0) {
                dataList.remove(i);
                i--;
            }
        }

        System.out.println("Setelah dihapus: " + dataList);
    }
}

/*
 * Sebelum dihapus: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Setelah dihapus: [0, 2, 4, 6, 8, 10]
 */



