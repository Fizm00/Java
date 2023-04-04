package Semester_2_Practice.Chapter12;

// Nama : Firza Himawan
// NIM  : 22537144003

public class FirzaCh12WriteChars {
    public static void main(String[] args) {
        writeChars(1);
        System.out.println();
        writeChars(2);
        System.out.println();
        writeChars(3);
        System.out.println();
        writeChars(4);
        System.out.println();
        writeChars(5);
        System.out.println();
        writeChars(6);
        System.out.println();
        writeChars(7);
        System.out.println();
        writeChars(8);
        System.out.println();
    }

    public static void writeChars(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        } else if (n == 1) {
            System.out.print("*");
        } else if (n == 2) {
            System.out.print("**");
        } else {
            System.out.print("<");
            writeChars(n - 2);
            System.out.print(">");
        }
    }
}

/*
 * output:
 * writeChars(1) = *
 * writeChars(2) = **
 * writeChars(3) = <*>
 * writeChars(4) = <**>
 * writeChars(5) = <<*>>
 * writeChars(6) = <<**>>
 * writeChars(7) = <<<*>>>
 * writeChars(8) = <<<**>>>
 */