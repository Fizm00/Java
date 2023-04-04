package Java_StrukturData;

import java.util.Scanner;

class Node { //deklarasi kelas Node
    int data1, data2; //deklarasi variabel data1 dan data2 bertipe integer
    Node prev, next; //deklarasi variabel prev dan next bertipe Node

    //Konstruktor kelas Node
    public Node(int d1, int d2) { 
        data1 = d1; //inisialisasi variabel data1 dengan nilai d1
        data2 = d2; //inisialisasi variabel data2 dengan nilai d2
        prev = null; //inisialisasi variabel prev dengan nilai null
        next = null; //inisialisasi variabel next dengan nilai null
    }
}
//--------------------------------------------------------------------

//deklarasi kelas DoubleLinkedList
class DoubleLinkedList {
    Node head, tail; //deklarasi variabel head dan tail bertipe Node

    public DoubleLinkedList() { //Konstruktor kelas DoubleLinkedList
        head = null; //inisialisasi variabel head dengan nilai null
        tail = null; //inisialisasi variabel tail dengan nilai null
    }
//--------------------------------------------------------------------
    public void insertAtBeginning(int d1, int d2) { //method untuk memasukkan data di awal list
        Node newNode = new Node(d1, d2); //membuat objek baru dari kelas Node
        if (head == null) { //jika head bernilai null
            head = newNode; //maka head diinisialisasi dengan nilai newNode
            tail = newNode; //dan tail diinisialisasi dengan nilai newNode
        } else { //jika head tidak bernilai null
            newNode.next = head; //maka newNode.next diinisialisasi dengan nilai head
            head.prev = newNode; //dan head.prev diinisialisasi dengan nilai newNode
            head = newNode; //dan head diinisialisasi dengan nilai newNode
        }
        System.out.println("Data berhasil dimasukkan di awal list."); //menampilkan pesan bahwa data berhasil dimasukkan di awal list
    }
//--------------------------------------------------------------------
    public void insertAtEnd(int d1, int d2) { //method untuk memasukkan data di akhir list
        Node newNode = new Node(d1, d2);//membuat objek baru dari kelas Node
        if (tail == null) { //jika tail bernilai null
            head = newNode;
            tail = newNode;
        } else { //jika tail tidak bernilai null
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Data berhasil dimasukkan di akhir list."); //menampilkan pesan bahwa data berhasil dimasukkan di akhir list
    }
//--------------------------------------------------------------------
    public void insertAfter(int key1, int key2, int d1, int d2) { //method untuk memasukkan data setelah data tertentu
        Node newNode = new Node(d1, d2); //membuat objek baru dari kelas Node
        Node temp = head; //membuat objek baru dari kelas Node dan menginisialisasinya dengan nilai head
        while (temp != null) { //perulangan selama temp tidak bernilai null
            if (temp.data1 == key1 && temp.data2 == key2) { //jika data pada temp sama dengan key1 dan key2
                if (temp == tail) { //jika temp sama dengan tail
                    insertAtEnd(d1, d2);
                } else { //jika temp tidak sama dengan tail
                    newNode.prev = temp;
                    newNode.next = temp.next;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                    System.out.println("Data berhasil dimasukkan setelah data tertentu."); //menampilkan pesan bahwa data berhasil dimasukkan setelah data tertentu
                }
                return;
            }
            temp = temp.next; //mengubah nilai temp dengan nilai temp.next
        }
        System.out.println("Data tidak ditemukan."); //menampilkan pesan bahwa data tidak ditemukan
    }
//--------------------------------------------------------------------
    public void deleteAtBeginning() { //method untuk menghapus data di awal list
        if (head == null) { //jika head bernilai null
            System.out.println("List kosong."); //menampilkan pesan bahwa list kosong
            return;
        } else if (head == tail) { //jika head sama dengan tail
            head = null;
            tail = null;
        } else { //jika head tidak sama dengan tail
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data di awal list berhasil dihapus."); //menampilkan pesan bahwa data di awal list berhasil dihapus
    }
//--------------------------------------------------------------------
    public void deleteAtEnd() { //method untuk menghapus data di akhir list
        if (tail == null) { //jika tail bernilai null
            System.out.println("List kosong."); //menampilkan pesan bahwa list kosong
            return;
        } else if (head == tail) { //jika head sama dengan tail
            head = null;
            tail = null;
        } else { //jika head tidak sama dengan tail
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data di akhir list berhasil dihapus."); //menampilkan pesan bahwa data di akhir list berhasil dihapus
    }
//--------------------------------------------------------------------
    public void delete(int d1, int d2) { //method untuk menghapus data tertentu
        if (head == null) { //jika head bernilai null
            System.out.println("List kosong."); //menampilkan pesan bahwa list kosong
            return;
        }
        Node temp = head; //membuat objek baru dari kelas Node dan menginisialisasinya dengan nilai head
        while (temp != null) { //perulangan selama temp tidak bernilai null
            if (temp.data1 == d1 && temp.data2 == d2) { //jika data pada temp sama dengan d1 dan d2
                if (temp == head) { //jika temp sama dengan head
                    deleteAtBeginning();
                } else if (temp == tail) { //jika temp sama dengan tail
                    deleteAtEnd();
                } else { //jika temp tidak sama dengan head dan tail
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    System.out.println("Data berhasil dihapus."); //menampilkan pesan bahwa data berhasil dihapus
                } 
                return;
            }
            temp = temp.next; //mengubah nilai temp dengan nilai temp.next
        }
        System.out.println("Data tidak ditemukan."); //menampilkan pesan bahwa data tidak ditemukan
    }
//--------------------------------------------------------------------
    public void displayFromBeginning() { //method untuk menampilkan data dari awal list
        Node temp = head; //membuat objek baru dari kelas Node dan menginisialisasinya dengan nilai head
        System.out.println("Data pada List:"); //menampilkan pesan bahwa data pada list
        while (temp != null) { //perulangan selama temp tidak bernilai null
            System.out.println(temp.data1 + " " + temp.data2); //menampilkan data pada temp
            temp = temp.next; //mengubah nilai temp dengan nilai temp.next
        }
    }
//--------------------------------------------------------------------
    public void displayFromEnd() { //method untuk menampilkan data dari akhir list
        Node temp = tail; //membuat objek baru dari kelas Node dan menginisialisasinya dengan nilai tail
        System.out.println("Data pada List (dari akhir):"); //menampilkan pesan bahwa data pada list (dari akhir)
        while (temp != null) { //perulangan selama temp tidak bernilai null
            System.out.println(temp.data1 + " " + temp.data2); //menampilkan data pada temp
            temp = temp.prev; //mengubah nilai temp dengan nilai temp.prev
        }
    }
}
//--------------------------------------------------------------------

public class prak06_22537144003 { //kelas utama
    public static void main(String[] args) { //method main
        DoubleLinkedList dll = new DoubleLinkedList(); //membuat objek baru dari kelas DoubleLinkedList
        Scanner scanner = new Scanner(System.in); //membuat objek baru dari kelas Scanner
        int choice, data1, data2, key1, key2; //mendeklarasikan variabel choice, data1, data2, key1, key2 dengan tipe data integer
        do {
            //menampilkan menu
            System.out.println("Menu:");
            System.out.println("1. Memasukkan data diawal List");
            System.out.println("2. Memasukkan data diakhir List");
            System.out.println("3. Memasukkan data setelah data tertentu");
            System.out.println("4. Menghapus data diawal List");
            System.out.println("5. Menghapus data diakhir List");
            System.out.println("6. Menghapus suatu data tertentu dari List");
            System.out.println("7. Menampilkan data dari awal List");
            System.out.println("8. Menampilkan data dari akhir List");
            System.out.println("9. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt(); //menginputkan pilihan menu

            //menjalankan method sesuai dengan pilihan menu
            switch (choice) {
                case 1: //memasukkan data diawal list
                    System.out.print("Masukkan data pertama: ");
                    data1 = scanner.nextInt();
                    System.out.print("Masukkan data kedua: ");
                    data2 = scanner.nextInt();
                    dll.insertAtBeginning(data1, data2);
                    break;

                case 2: //memasukkan data diakhir list
                    System.out.print("Masukkan data pertama: ");
                    data1 = scanner.nextInt();
                    System.out.print("Masukkan data kedua: ");
                    data2 = scanner.nextInt();
                    dll.insertAtEnd(data1, data2);
                    break;

                case 3: //memasukkan data setelah data tertentu
                    System.out.print("Masukkan data yang ingin dicari: ");
                    key1 = scanner.nextInt();
                    System.out.print("Masukkan data kedua yang ingin dicari: ");
                    key2 = scanner.nextInt();
                    System.out.print("Masukkan data pertama: ");
                    data1 = scanner.nextInt();
                    System.out.print("Masukkan data kedua: ");
                    data2 = scanner.nextInt();
                    dll.insertAfter(key1, key2, data1, data2);
                    break;

                case 4: //menghapus data diawal list
                    dll.deleteAtBeginning();
                    break;

                case 5: //menghapus data diakhir list
                    dll.deleteAtEnd();
                    break;

                case 6: //menghapus data tertentu
                    System.out.print("Masukkan data pertama yang ingin dihapus: ");
                    data1 = scanner.nextInt();
                    System.out.print("Masukkan data kedua yang ingin dihapus: ");
                    data2 = scanner.nextInt();
                    dll.delete(data1, data2);
                    break;

                case 7: //menampilkan data dari awal list
                    dll.displayFromBeginning();
                    break;

                case 8: //menampilkan data dari akhir list
                    dll.displayFromEnd();
                    break;

                case 9: //keluar
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;

                default: //pilihan tidak valid
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }

            System.out.println();
        } while (choice != 9); //perulangan selama choice tidak sama dengan 9
    }
} //end of class prak06_22537144003