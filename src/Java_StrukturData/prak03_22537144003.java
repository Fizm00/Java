//Nama : Firza Himawan
//NIM  : 22537144003

package Java_StrukturData;

//Import untuk kelas-kelas yang digunakan
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//---------------------------------------

//deklarasi kelas patient
class Patient {
    //deklarasi kelas patient
    private String name;
    private String complaint;
    private String address;
//---------------------------------------

//Konstruktor kelas patient
    public Patient(String name, String complaint, String address) { //membuat konstruktor
        this.name = name;
        this.complaint = complaint;
        this.address = address;
    }
//---------------------------------------

    public String getName() { //method untuk mengambil nama
        return name; //mengembalikan nilai nama
    }

    public String getComplaint() { //method untuk mengambil keluhan
        return complaint; //mengembalikan nilai keluhan
    }

    public String getAddress() { //method untuk mengambil alamat
        return address; //mengembalikan nilai alamat
    }
}

public class prak03_22537144003 { //deklarasi kelas prak03_22537144003
    private Queue<Patient> queue = new LinkedList<>(); //deklarasi queue

    public static void main(String[] args) { //method main
        prak03_22537144003 app = new prak03_22537144003(); //membuat objek app
        app.run(); //memanggil method run
    }

    public void run() { //method run
        Scanner scanner = new Scanner(System.in); //membuat objek scanner
        int choice = 0; //inisialisasi variabel choice dengan nilai 0
        do {//perulangan do while

            //menampilkan menu
            System.out.println("===== ANTRIAN PASIEN ====="); 
            System.out.println("1. Pendaftaran pasien");
            System.out.println("2. Memanggil pasien (menghapus dari antrian)");
            System.out.println("3. Melihat daftar antrian");
            System.out.println("0. Keluar");

            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt(); //mengambil inputan dari user

            switch (choice) { //perulangan switch case
                case 1:
                    registerPatient(); //memanggil method registerPatient
                    break;
                case 2:
                    callPatient(); //memanggil method callPatient
                    break;
                case 3:
                    displayQueue(); //memanggil method displayQueue
                    break;
                case 0:
                    System.out.println("Terima kasih!"); //menampilkan pesan "Terima kasih!"
                    break;
                default:
                    System.out.println("Pilihan tidak valid!"); //menampilkan pesan "Pilihan tidak valid!"
            }
        } while (choice != 0); //perulangan akan berhenti jika choice bernilai 0
    }

    private void registerPatient() { //method registerPatient
        Scanner scanner = new Scanner(System.in); //membuat objek scanner

        System.out.println("===== PENDAFTARAN PASIEN ====="); //menampilkan pesan "===== PENDAFTARAN PASIEN ====="
        System.out.print("Masukkan nama pasien: "); //menampilkan pesan "Masukkan nama pasien: "
        String name = scanner.nextLine(); //mengambil inputan dari user

        System.out.print("Masukkan keluhan pasien: "); //menampilkan pesan "Masukkan keluhan pasien: "
        String complaint = scanner.nextLine(); //mengambil inputan dari user

        System.out.print("Masukkan alamat pasien: "); //menampilkan pesan "Masukkan alamat pasien: "
        String address = scanner.nextLine(); //mengambil inputan dari user

        Patient patient = new Patient(name, complaint, address); //membuat objek patient
        queue.add(patient); //menambahkan objek patient ke queue

        System.out.println("Pasien " + patient.getName() + " telah terdaftar."); //menampilkan pesan "Pasien " + patient.getName() + " telah terdaftar."
    }

    private void callPatient() { //method callPatient
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!"); //menampilkan pesan "Antrian kosong!"
        } else { //jika antrian tidak kosong
            Patient patient = queue.poll(); //mengambil objek patient dari queue
            System.out.println("Memanggil pasien " + patient.getName() + " (Keluhan: " + patient.getComplaint() + ", Alamat: " + patient.getAddress() + ")");
        }
    }

    private void displayQueue() { //method displayQueue
        System.out.println("===== DAFTAR ANTRIAN ====="); //menampilkan pesan "===== DAFTAR ANTRIAN ====="
        if (queue.isEmpty()) { //jika antrian kosong
            System.out.println("Antrian kosong!"); //menampilkan pesan "Antrian kosong!"
        } else { //jika antrian tidak kosong
            int i = 1; //inisialisasi variabel i dengan nilai 1
            for (Patient patient : queue) { //perulangan for each
                System.out.println(i + ". " + patient.getName() + " (Keluhan: " + patient.getComplaint() + ", Alamat: " + patient.getAddress() + ")");
                i++;
            }
        }
    }
} //akhir kelas prak03_22537144003
