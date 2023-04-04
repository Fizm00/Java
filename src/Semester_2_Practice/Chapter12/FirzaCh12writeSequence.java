package Semester_2_Practice.Chapter12;

// Nama : Firza Himawan
// NIM  : 22537144003

public class FirzaCh12writeSequence {
    public static void main(String[] args) {
        writeSequence(1);
        System.out.println();	
        writeSequence(2);
        System.out.println();
        writeSequence(3);
        System.out.println();
        writeSequence(4);
        System.out.println();
        writeSequence(5);
        System.out.println();
        writeSequence(6);
        System.out.println();
        writeSequence(7);
        System.out.println();
        writeSequence(8);
        System.out.println();
    }
    
    public static void writeSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid argument");
        } else if (n == 1) {
            System.out.print("1 ");
        } else if (n == 2) {
            System.out.print("1 1 ");
        } else {
            System.out.print((n + 1) / 2 + " ");
            writeSequence(n - 2); 
            System.out.print((n + 1) / 2 + " ");
        }
    }
}

/*
 * writeSequence(1); =	1
 * writeSequence(2); =	1 1
 * writeSequence(3); =	2 1 2
 * writeSequence(4); =	2 1 1 2
 * writeSequence(5); =	3 2 1 2 3
 * writeSequence(6); =	3 2 1 1 2 3
 * writeSequence(7); =	4 3 2 1 2 3 4
 * writeSequence(8); =	4 3 2 1 1 2 3 4
 */