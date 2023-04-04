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
    private String name;
    private String complaint;
    private String address;
//---------------------------------------

    //Konstruktor kelas patient
    public Patient(String name, String complaint, String address) {
        this.name = name;
        this.complaint = complaint;
        this.address = address;
    }

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
//---------------------------------------

//deklarasi kelas prak05_22537144003
public class prak05_22537144003 {
    private Queue<Patient> queue = new LinkedList<>(); //deklarasi queue
    public static void main(String[] args) {
        prak05_22537144003 app = new prak05_22537144003(); //membuat objek app
        app.run(); //memanggil method run
    }

    public void run() { //method run
        Scanner scanner = new Scanner(System.in); //membuat objek scanner
        int choice = 0; //inisialisasi variabel choice dengan nilai 0

        //perulangan do while
        do {
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
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0); //perulangan akan berhenti jika choice bernilai 0
    } //akhir method run

    //method untuk mendaftarkan pasien
    private void registerPatient() {
        Scanner scanner = new Scanner(System.in); //membuat objek scanner

        //mengambil inputan dari user
        System.out.println("===== PENDAFTARAN PASIEN =====");
        System.out.print("Masukkan nama pasien: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan keluhan pasien: ");
        String complaint = scanner.nextLine();

        System.out.print("Masukkan alamat pasien: ");
        String address = scanner.nextLine();

        //membuat objek patient
        Patient patient = new Patient(name, complaint, address);
        queue.add(patient);

        System.out.println("Pasien " + patient.getName() + " telah terdaftar.");
    } //akhir method registerPatient

    //method untuk memanggil pasien
    private void callPatient() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            Patient patient = queue.poll();
            System.out.println("Memanggil pasien " + patient.getName() + " (Keluhan: " + patient.getComplaint() + ", Alamat: " + patient.getAddress() + ")");
        }
    } //akhir method callPatient

    //method untuk menampilkan daftar antrian
    private void displayQueue() {
        System.out.println("===== DAFTAR ANTRIAN =====");
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            int i = 1;
            for (Patient patient : queue) {
                System.out.println(i + ". " + patient.getName() + " (Keluhan: " + patient.getComplaint() + ", Alamat: " + patient.getAddress() + ")");
                i++;
            }
        }
    }
} //akhir kelas prak05_22537144003

