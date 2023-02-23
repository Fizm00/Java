package Java_StrukturData;

import java.util.Scanner;

public class ArrayProgram {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int[] arr = new int[10];
      int size = 0;
      int choice, value, index;
      
      while (true) {
         System.out.println("Pilihan Menu:");
         System.out.println("1. Masukkan data");
         System.out.println("2. Cari data");
         System.out.println("3. Hapus data");
         System.out.println("4. Keluar");
         System.out.print("Masukkan pilihan Anda: ");
         choice = input.nextInt();
         
         switch (choice) {
            case 1:
               if (size == 100) {
                  System.out.println("Array sudah penuh, tidak bisa menambah data lagi");
               } else {
                  System.out.print("Masukkan data: ");
                  value = input.nextInt();
                  arr[size] = value;
                  size++;
                  System.out.println("Data berhasil ditambahkan");
               }
               break;
            case 2:
               System.out.print("Masukkan data yang ingin dicari: ");
               value = input.nextInt();
               index = -1;
               for (int i = 0; i < size; i++) {
                  if (arr[i] == value) {
                     index = i;
                     break;
                  }
               }
               if (index != -1) {
                  int count = 0;
                  for (int i = 0; i < size; i++) {
                     if (arr[i] == value) {
                        count++;
                     }
                  }
                  System.out.println("Data ditemukan pada index ke-" + index + " dengan jumlah " + count + " buah");
               } else {
                  System.out.println("Data tidak ditemukan");
               }
               break;
            case 3:
               System.out.print("Masukkan data yang ingin dihapus: ");
               value = input.nextInt();
               index = -1;
               for (int i = 0; i < size; i++) {
                  if (arr[i] == value) {
                     index = i;
                     break;
                  }
               }
               if (index != -1) {
                  for (int i = index; i < size - 1; i++) {
                     arr[i] = arr[i + 1];
                  }
                  size--;
                  System.out.println("Data berhasil dihapus");
               } else {
                  System.out.println("Data tidak ditemukan");
               }
               break;
            case 4:
               System.out.println("Terima kasih sudah menggunakan program ini");
               System.exit(0);
               break;
            default:
               System.out.println("Pilihan tidak valid, masukkan pilihan 1-4");
               break;
            }
        }
    }
}

/*
 * buatlah program array java dengan ketentuan sebagai berikut:
1. memiliki menu pilihan yang dapat dipilih oleh pengguna seperti memasukkan data, mengurutkan data, mencari data, menghapus data dan cetak data. Tambahkan pula pilihan untuk keluar dari program.
2. untuk pencarian data, apabila data ditemukan, terdapat informasi tambahan yaitu berapa jumlah data tersebut. Misalnya data yang ada dalam array adalah 19, 23, 4, 23, 9, dan 8; maka apabila kita mencari data 23 maka hasil pencariannya adalah data tersebut ada/ditemukan dengan jumlah 2 buah.
 */