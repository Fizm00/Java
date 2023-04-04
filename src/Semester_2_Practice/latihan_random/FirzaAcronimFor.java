package Semester_2_Practice;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FirzaAcronimFor {
    public static String acronymFor(List<String> kalimat) {
        if (kalimat.isEmpty()) {
            return "";
        }
        StringBuilder acronym = new StringBuilder();
        for (String kata : kalimat) {
            if (kata.length() > 0 && Character.isUpperCase(kata.charAt(0))) {
                acronym.append(kata.charAt(0));
            }
        }
        return acronym.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan beberapa kata dengan huruf kapital pada awal kata: ");
        String input = sc.nextLine();
        String[] kalimatArr = input.split(" ");
        List<String> kalimatList = new ArrayList<>();
        for (String kata : kalimatArr) {
            kalimatList.add(kata);
        }
        System.out.println("Acronym: " + acronymFor(kalimatList));
        sc.close();
    }
}

/*
 * Ketika program dijalan kan akan muncul seperti dibawah ini
 * 
 * "masukkan beberapa kata dengan huruf kapital pada awal kata:".
 * 
 * Kemudian kita ketik atau tuliskan kata/daftar dengan huruf kapital pada awal kata. Sebagai contoh: Laughing, Out, Loud.
 * maka outputnya akan menjadi seperti ini:
 * 
 * "masukkan beberapa kata dengan huruf kapital pada awal kata: Laughing, Out, Loud    
 * Acronym: LOL"
 * 
 */