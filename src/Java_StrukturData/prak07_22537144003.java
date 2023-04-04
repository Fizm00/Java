package Java_StrukturData;

import java.util.Scanner;

public class prak07_22537144003 {
    public static void main(String[] args) { //method main
        Scanner scanner = new Scanner(System.in); //membuat objek scanner
        LinkedList linkedList = new LinkedList(); //membuat objek linkedList

        System.out.print("Masukkan jumlah data: "); //meminta input jumlah data
        int n = scanner.nextInt(); //mengambil inputan dari user

        for (int i = 0; i < n; i++) { //perulangan sebanyak jumlah data yang akan di masukkan
            System.out.print("Masukkan data ke-" + (i+1) + ": "); //meminta input data
            int data = scanner.nextInt(); //mengambil inputan dari user
            linkedList.add(data); //memasukkan data ke linked list
        }

        System.out.print("Masukkan data yang ingin dimasukkan sebelumnya: "); //meminta input data yang ingin dimasukkan sebelumnya
        int before = scanner.nextInt(); //mengambil inputan dari user

        System.out.print("Masukkan data yang ingin dimasukkan: "); //meminta input data yang ingin dimasukkan
        int newData = scanner.nextInt(); //mengambil inputan dari user

        linkedList.insertBefore(before, newData); //memasukkan data baru sebelum data yang diinginkan

        System.out.println("Hasil linked list setelah dimasukkan: "); //menampilkan hasil linked list setelah dimasukkan
        linkedList.printList(); //menampilkan linked list
    }
}
//------------------------------------------------------------------------------------------------------------
class Node { //deklarasi kelas Node
    int data; //deklarasi variabel data bertipe integer
    Node next; //deklarasi variabel next bertipe Node

    public Node(int data) { //konstruktor kelas Node
        this.data = data; //inisialisasi variabel data dengan parameter data
        this.next = null; //inisialisasi variabel next dengan nilai null
    }
}
//------------------------------------------------------------------------------------------------------------
class LinkedList { //deklarasi kelas LinkedList
    Node head; //deklarasi variabel head bertipe Node

    public void add(int data) { //method untuk menambah data
        Node newNode = new Node(data); //membuat objek newNode dengan parameter data
        if (head == null) { 
            head = newNode; //jika head bernilai null, maka head akan diinisialisasi dengan nilai newNode
        } else { //jika head tidak bernilai null
            Node currentNode = head; //membuat objek currentNode dengan nilai head

            while (currentNode.next != null) {
                currentNode = currentNode.next; //perulangan untuk mengecek apakah currentNode.next bernilai null
            }

            currentNode.next = newNode; //jika currentNode.next bernilai null, maka currentNode.next akan diinisialisasi dengan nilai newNode
        }
    }
//------------------------------------------------------------------------------------------------------------
    public void insertBefore(int before, int newData) { //method untuk memasukkan data baru sebelum data yang diinginkan
        Node newNode = new Node(newData); //membuat objek newNode dengan parameter newData
        if (head == null) {
            head = newNode; //jika head bernilai null, maka head akan diinisialisasi dengan nilai newNode
        } else if (head.data == before) {
            newNode.next = head;
            head = newNode; //jika head.data bernilai sama dengan before, maka newNode.next akan diinisialisasi dengan nilai head dan head akan diinisialisasi dengan nilai newNode
        } else { //jika head.data tidak bernilai sama dengan before
            Node currentNode = head; //membuat objek currentNode dengan nilai head

            while (currentNode.next != null && currentNode.next.data != before) { 
                currentNode = currentNode.next; //perulangan untuk mengecek apakah currentNode.next bernilai null dan currentNode.next.data bernilai sama dengan before
            }

            if (currentNode.next == null) { //jika currentNode.next bernilai null
                System.out.println(before + " tidak ditemukan dalam linked list."); //menampilkan pesan bahwa before tidak ditemukan dalam linked list
            } else { //jika currentNode.next tidak bernilai null
                newNode.next = currentNode.next; //menginisialisasi newNode.next dengan nilai currentNode.next
                currentNode.next = newNode; //menginisialisasi currentNode.next dengan nilai newNode
            }
        }
    } //end of method insertBefore
//------------------------------------------------------------------------------------------------------------
    public void printList() { //method untuk menampilkan linked list
        Node currentNode = head; //membuat objek currentNode dengan nilai head

        while (currentNode != null) { //perulangan untuk mengecek apakah currentNode bernilai null
            System.out.print(currentNode.data + " "); //menampilkan data dari linked list
            currentNode = currentNode.next; //perulangan untuk menampilkan data dari linked list
        }

        System.out.println();
    }
} //end of class LinkedList
//------------------------------------------------------------------------------------------------------------

