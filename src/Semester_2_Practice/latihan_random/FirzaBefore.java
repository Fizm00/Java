package Semester_2_Practice;

//Firza Himawan
//22537144003

public class FirzaBefore {
    public static boolean before(int month1, int day1, int month2, int day2) {
        if (month1 < month2) {
            return true;
        } else if (month1 == month2 && day1 < day2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(before(6, 13, 9, 20)); //true
        System.out.println(before(10, 1, 2, 25)); //false
        System.out.println(before(8, 15, 8, 15)); //false
        System.out.println(before(8, 15, 8, 16)); //true
    }
}


/*
 * 6, 13, 9, 20 = 3 juni datang sebelum 20 september (true)
 * 10, 1, 2, 25 = 1 0ktober tidak datang sebelum 25 februari (false)
 * 8, 15, 8,15 = 15 agustus tidak datang sebelum 15 agustus (false)
 * 8, 15, 8, 16 = 15 agustus datang sebelum 16 agustus (true)
 */