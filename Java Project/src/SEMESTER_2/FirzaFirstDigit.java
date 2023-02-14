package SEMESTER_2;

public class FirzaFirstDigit {
    public static void main(String[] args) {
       int a = 3572;
       int b = -947;
       int c = 6;
       int d = 35;
       int e = 123456;
       System.out.printf(format: "Bilangan %d memiliki digit pertama %d.", a, firstDigit(a));
       System.out.printf(format: "\nBilangan %d memiliki digit pertama %d.", b, firstDigit(b));
       System.out.printf(format: "\nBilangan %d memiliki digit pertama %d.", c, firstDigit(c));
       System.out.printf(format: "\nBilangan %d memiliki digit pertama %d.", d, firstDigit(d));
       System.out.printf(format: "\nBilangan %d memiliki digit pertama %d.", e, firstDigit(e));
   }
   public static int firstDigit(int angka) {
       while (angka >= 10 || angka <= -10) {
          angka = angka / 10;
       }
       return Math.abs(angka);
   }
 }