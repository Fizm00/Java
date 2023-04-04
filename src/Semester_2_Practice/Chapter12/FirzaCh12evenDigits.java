package Semester_2_Practice.Chapter12;

// Nama : Firza Himawan
// NIM  : 22537144003

public class FirzaCh12evenDigits {

    public static int evenDigits(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 != 0) {
            return evenDigits(n / 10);
        }
        else {
            return evenDigits(n / 10) * 10 + n % 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(evenDigits(8342116));
        System.out.println(evenDigits(4109));
        System.out.println(evenDigits(8));
        System.out.println(evenDigits(-34512));
        System.out.println(evenDigits(-163505));
        System.out.println(evenDigits(3052));
        System.out.println(evenDigits(7010496));
        System.out.println(evenDigits(35179));
        System.out.println(evenDigits(7));
    }

}

/*
 * output:
 * evenDigits(8342116) = 8426
 * evenDigits(4109) = 40
 * evenDigits(8) = 8
 * evenDigits(-34512) = -42
 * evenDigits(-163505) = -60
 * evenDigits(3052) = 2
 * evenDigits(7010496) = 46
 * evenDigits(35179) = 0
 * evenDigits(7) = 0
 */



