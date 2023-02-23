package Java_StrukturData;

import java.util.Scanner;

public class ArrayProgram2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] data = new int[100]; //aray sebanyak 100 indeks
    int jumlahData = 0;

    while (true) {
      System.out.println("Pilih menu:");
      System.out.println("1. Masukkan data");
      System.out.println("2. Urutkan data");
      System.out.println("3. Cari data");
      System.out.println("4. Hapus data");
      System.out.println("5. Cetak data");
      System.out.println("6. Keluar");
      System.out.print("Masukkan pilihan: ");
      int pilihan = scan.nextInt();

      if (pilihan == 1) {
        System.out.print("Masukkan data: ");
        int inputData = scan.nextInt();
        data[jumlahData] = inputData;
        jumlahData++;
      } else if (pilihan == 2) {
        for (int i = 0; i < jumlahData - 1; i++) {
          for (int j = 0; j < jumlahData - 1; j++) {
            if (data[j] > data[j + 1]) {
              int temp = data[j];
              data[j] = data[j + 1];
              data[j + 1] = temp;
            }
          }
        }
        System.out.println("Data berhasil diurutkan");
      } else if (pilihan == 3) {
        System.out.print("Masukkan data yang dicari: ");
        int cariData = scan.nextInt();
        int jumlahDitemukan = 0;
        for (int i = 0; i < jumlahData; i++) {
          if (data[i] == cariData) {
            jumlahDitemukan++;
          }
        }
        if (jumlahDitemukan > 0) {
          System.out.println("Data ditemukan sebanyak " + jumlahDitemukan + " buah");
        } else {
          System.out.println("Data tidak ditemukan");
        }
      } else if (pilihan == 4) {
        System.out.print("Masukkan data yang ingin dihapus: ");
        int hapusData = scan.nextInt();
        for (int i = 0; i < jumlahData; i++) {
          if (data[i] == hapusData) {
            for (int j = i; j < jumlahData - 1; j++) {
              data[j] = data[j + 1];
            }
            jumlahData--;
            System.out.println("Data berhasil dihapus");
          }
        }
      } else if (pilihan == 5) {
        System.out.println("Data: ");
        for (int i = 0; i < jumlahData; i++) {
          System.out.print(data[i] + " ");
        }
        System.out.println();
        } else if (pilihan == 6) {
        System.out.println("Program selesai");
        break;
        } else {
        System.out.println("Pilihan tidak valid");
      }
    }
  }
}

//contoh data : 19, 23, 4, 23, 9, dan 8