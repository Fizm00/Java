package Java_StrukturData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient {
    private String name;
    private String complaint;
    private String address;

    public Patient(String name, String complaint, String address) {
        this.name = name;
        this.complaint = complaint;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getAddress() {
        return address;
    }
}

public class prak03_22537144003 {
    private Queue<Patient> queue = new LinkedList<>();

    public static void main(String[] args) {
        prak03_22537144003 app = new prak03_22537144003();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("===== ANTRIAN PASIEN =====");
            System.out.println("1. Pendaftaran pasien");
            System.out.println("2. Memanggil pasien (menghapus dari antrian)");
            System.out.println("3. Melihat daftar antrian");
            System.out.println("0. Keluar");

            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    callPatient();
                    break;
                case 3:
                    displayQueue();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    private void registerPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== PENDAFTARAN PASIEN =====");
        System.out.print("Masukkan nama pasien: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan keluhan pasien: ");
        String complaint = scanner.nextLine();

        System.out.print("Masukkan alamat pasien: ");
        String address = scanner.nextLine();

        Patient patient = new Patient(name, complaint, address);
        queue.add(patient);

        System.out.println("Pasien " + patient.getName() + " telah terdaftar.");
    }

    private void callPatient() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            Patient patient = queue.poll();
            System.out.println("Memanggil pasien " + patient.getName() + " (Keluhan: " + patient.getComplaint() + ", Alamat: " + patient.getAddress() + ")");
        }
    }

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
}
