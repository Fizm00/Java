package Semester_2_Practice;

//Firza Himawan
//22537144003

public class FirzaallDigitsOdd {
    public static boolean allDigitsOdd(int num) {
        int digit;
        num = Math.abs (num);
        while (num > 0) {
            digit = num % 10;
            if (digit % 2 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allDigitsOdd(4822116)); 
        System.out.println(allDigitsOdd(135319)); 
        System.out.println(allDigitsOdd(9175293));
        System.out.println(allDigitsOdd(-137));
    }
}

/*
 * angka 4822116 mereturn false
 * angka 135319 mereturn true
 * angka 9175293 mereturn false
 * angka -137 mereturn true
 */