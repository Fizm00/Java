package Semester_2_Practice;

public class FirzaHasMidPoint {
    public static boolean hasMidpoint(int num1, int num2, int num3) {
        int min = Math.min(num1, Math.min(num2, num3));
        int max = Math.max(num1, Math.max(num2, num3));
        int mid = min + (max - min) / 2;

        if (mid == num1 || mid == num2 || mid == num3) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(hasMidpoint(4, 6, 8)); // prints true
        System.out.println(hasMidpoint(2, 10, 6)); // prints true
        System.out.println(hasMidpoint(8, 8, 8)); // prints true
        System.out.println(hasMidpoint(25, 10, -5)); // prints true
        System.out.println(hasMidpoint(3, 1, 3)); // prints false
        System.out.println(hasMidpoint(1, 3, 1)); // prints false
        System.out.println(hasMidpoint(21, 9, 58)); // prints false
        System.out.println(hasMidpoint(2, 8, 16)); // prints false
    }
}

/*
 * ANGKA
 * 4, 6, 8 = true
 * 2, 10, 6 = true
 * 8, 8, 8 = true
 * 25, 10, -5 = true
 * 
 * ANGKA
 * 3, 1, 3 = false
 * 1, 3, 1 = false
 * 21, 9, 58 = false
 * 2, 8, 16 = false
 */