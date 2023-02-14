package Semester_2_Practice;

public class FirzaHopscotch {
    public static void hopscotch(int hops) {
        int num = 1;
        for (int i = 1; i <= hops; i++) {
            System.out.println("   " + num);
            System.out.println((num + 1) + "     " + (num + 2));
            num += 3;
        }
        System.out.println("   "+(num)+"   ");
    }

    public static void main(String[] args) {
        hopscotch(3);
    }
}

/*
 * output =
   1
2     3
   4
5     6
   7
8     9
   10
 */
