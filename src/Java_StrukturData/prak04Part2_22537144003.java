package Java_StrukturData;

import java.util.Scanner;

class NodeMahasiswa { // class NodeMhs
    public String nim; 
    public String nama;
    public String kota;
    public NodeMahasiswa next;
//------------------------------------------------------------------
    // konstruktor
    public NodeMahasiswa(String nimMhs, String namaMhs, String kotaMhs) { 
        nim = nimMhs; // mengisi data
        nama = namaMhs;
        kota = kotaMhs;
        next = null;
    }
//------------------------------------------------------------------
    // method untuk menampilkan data
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKota() {
        return kota;
    }
} // end class NodeMhs
///////////////////////////////////////////////////////////////////////

class LinkListMhs { // class LinkList
    private NodeMahasiswa first; // referensi ke item pertama

    public LinkListMhs() { // konstruktor
        first = null;
    }

    public boolean isEmpty() { // true jika list kosong
        return (first == null);
    }

    public void insert(String nimMhs, String namaMhs, String kotaMhs) { // menambah data di awal
        NodeMahasiswa newNode = new NodeMahasiswa(nimMhs, namaMhs, kotaMhs); // buat node baru
        NodeMahasiswa prev = null; // inisialisasi node sebelum dan setelah node yang akan di-insert
        NodeMahasiswa current = first;

        if (isEmpty()) { // jika list kosong, data baru langsung dimasukkan sebagai first node
            first = newNode;
            return;
        }
        while (current != null && nimMhs.compareTo(current.getNim()) > 0) { // selama belum sampai akhir dan data baru lebih kecil dari data yang sedang diperiksa
            prev = current;
            current = current.next;
        }

        if (prev == null) { // jika data baru harus dimasukkan di awal
            first = newNode;
        } else { // jika data baru harus dimasukkan di tengah atau di akhir
            prev.next = newNode;
        }
        newNode.next = current;
    }

    public NodeMahasiswa findByNIM(String nimMhs) { // mencari data berdasarkan NIM
        NodeMahasiswa current = first; // mulai dari awal
        while (current != null && !current.getNim().equals(nimMhs)) { // selama belum ketemu dan belum sampai akhir
            current = current.next; // pindah ke node berikutnya
        }
        return current; // mengembalikan node yang ditemukan
    }

    public NodeMahasiswa findByName(String namaMhs) { // mencari data berdasarkan Nama
        NodeMahasiswa current = first; // mulai dari awal
        while (current != null && !current.getNama().equals(namaMhs)) { // selama belum ketemu dan belum sampai akhir
            current = current.next; // pindah ke node berikutnya
        }
        return current; // mengembalikan node yang ditemukan
    }

    public NodeMahasiswa findByKota(String kotaMhs) { // mencari data berdasarkan Kota
        NodeMahasiswa current = first; // mulai dari awal
        while (current != null && !current.getKota().equals(kotaMhs)) { // selama belum ketemu dan belum sampai akhir
            current = current.next; // pindah ke node berikutnya
        }
        return current; // mengembalikan node yang ditemukan
    }

    public NodeMahasiswa find(String key, int option) { // mencari data berdasarkan NIM, Nama, atau Kota
        NodeMahasiswa current = first;
        while (current != null) {
            switch (option) {
                case 1: // NIM
                    if (current.getNim().equals(key)) { 
                        return current;
                    }
                    break;
                case 2: // Nama
                    if (current.getNama().equalsIgnoreCase(key)) {
                        return current;
                    }
                    break;
                case 3: // Kota
                    if (current.getKota().equalsIgnoreCase(key)) {
                        return current;
                    }
                    break;
                default:
                    break;
            }
            current = current.next; // pindah ke node berikutnya
        }
        return null;
    }

    public NodeMahasiswa deleteFirst() { // menghapus data di awal
        NodeMahasiswa temp = first; // menyimpan referensi ke node pertama
        first = first.next; // menghapus node pertama
        return temp; // mengembalikan node yang dihapus
    }

    public void displayList() { // menampilkan data
        System.out.println("Data Mahasiswa:");
        System.out.println("---------------");
        NodeMahasiswa current = first;
        while (current != null) {
            // menampilkan data
            System.out.println("NIM  : " + current.getNim());
            System.out.println("Nama : " + current.getNama());
            System.out.println("Kota : " + current.getKota());
            System.out.println("---------------");
            current = current.next;
        }
        System.out.println(); // ganti baris
    }
} // end class LinkList
///////////////////////////////////////////////////////////////////////

class prak04Part2_22537144003 { // class prak04_22537144003
    public static void main(String[] args) { // method main
        Scanner input = new Scanner(System.in); 
        LinkListMhs list = new LinkListMhs(); // membuat objek LinkList
        int searchChoice, choice = 0; // variabel untuk menyimpan pilihan menu

        do { // menu
            // menampilkan menu
            System.out.println("Menu:");
            System.out.println("1. Memasukkan Data Mahasiswa");
            System.out.println("2. Mencari Data Mahasiswa");
            System.out.println("3. Menghapus Data Mahasiswa");
            System.out.println("4. Menampilkan Seluruh Data Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = input.nextInt(); // memasukkan pilihan menu

            switch (choice) {
                case 1: // memasukkan data mahasiswa
                    System.out.print("Masukkan NIM\t: ");
                    String nimMhs = input.next();
                    System.out.print("Masukkan Nama\t: ");
                    String namaMhs = input.next();
                    System.out.print("Masukkan Kota\t: ");
                    String kotaMhs = input.next();

                    NodeMahasiswa existingNode = list.findByNIM(nimMhs); // mencari data berdasarkan NIM

                    if (existingNode != null) { // jika data sudah ada
                        System.out.println("Data Mahasiswa dengan NIM " + nimMhs + " sudah ada"); // tampilkan pesan
                        break;
                    }
                
                    list.insert(nimMhs, namaMhs, kotaMhs); // memasukkan data ke awal
                    System.out.println("Data Mahasiswa berhasil dimasukkan"); // tampilkan pesan
                    break;
                case 2: // mencari data mahasiswa
                    System.out.println("1. Cari berdasarkan NIM");
                    System.out.println("2. Cari berdasarkan Nama");
                    System.out.println("3. Cari berdasarkan Kota");
                    System.out.print("Pilihan\t\t: ");
                    searchChoice = input.nextInt(); // menyimpan pilihan menu

                    switch (searchChoice) {
                        case 1: // mencari berdasarkan NIM
                            System.out.print("Masukkan NIM\t: "); // meminta input NIM
                            String searchNim = input.next(); // menyimpan input NIM
                    
                            NodeMahasiswa resultByNim = list.findByNIM(searchNim); // mencari data berdasarkan NIM
                            // menampilkan data
                            if (resultByNim != null) {
                                System.out.println("Data Mahasiswa dengan NIM " + searchNim + " ditemukan:");
                                System.out.println("Nama\t\t: " + resultByNim.getNama());
                                System.out.println("Kota Asal\t: " + resultByNim.getKota());
                            } else {
                                System.out.println("Data Mahasiswa dengan NIM " + searchNim + " tidak ditemukan");
                            }
                            break;
                    
                        case 2: // mencari berdasarkan Nama
                            System.out.print("Masukkan Nama\t: "); // meminta input Nama
                            String searchNama = input.next();
                    
                            NodeMahasiswa resultByName = list.findByName(searchNama); // mencari data berdasarkan Nama
                    
                            if (resultByName != null) { // menampilkan data
                                System.out.println("Data Mahasiswa dengan Nama " + searchNama + " ditemukan:");
                                System.out.println("NIM\t\t: " + resultByName.getNim());
                                System.out.println("Kota Asal\t: " + resultByName.getKota());
                            } else {
                                System.out.println("Data Mahasiswa dengan Nama " + searchNama + " tidak ditemukan");
                            }
                            break;
                    
                        case 3: // mencari berdasarkan Kota
                            System.out.print("Masukkan Kota\t: "); // meminta input Kota
                            String searchKota = input.next();
                    
                            NodeMahasiswa resultByCity = list.findByKota(searchKota); // mencari data berdasarkan Kota
                    
                            if (resultByCity != null) { // menampilkan data
                                System.out.println("Data Mahasiswa dengan Kota Asal " + searchKota + " ditemukan:");
                                System.out.println("NIM\t\t: " + resultByCity.getNim());
                                System.out.println("Nama\t\t: " + resultByCity.getNama());
                            } else {
                                System.out.println("Data Mahasiswa dengan Kota Asal " + searchKota + " tidak ditemukan");
                            }
                            break;
                    
                        default:
                            System.out.println("Pilihan tidak valid");
                    }
                    break;
            
                case 3: // menghapus data mahasiswa
                    if (list.isEmpty()) {
                        System.out.println("Tidak ada data mahasiswa yang bisa dihapus");
                    } else {
                        NodeMahasiswa removedNode = list.deleteFirst(); // menghapus data dari awal
                        System.out.println("Data Mahasiswa dengan NIM " + removedNode.getNim() + " telah dihapus");
                    }
                    break;
            
                case 4: // menampilkan seluruh data mahasiswa
                    if (list.isEmpty()) {
                        System.out.println("Tidak ada data mahasiswa yang tersimpan");
                    } else {
                        System.out.println("Daftar Mahasiswa: ");
                        list.displayList();
                    }
                    break;
                
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini");
                    input.close(); // tutup Scanner ketika selesai menggunakan
                    System.exit(0); // keluar dari program
                    break;
            
                default:
                    System.out.println("Pilihan tidak valid");
            }
            
            System.out.println("===================================");
            System.out.println(); // memberikan baris kosong untuk memisahkan setiap iterasi loop
        }   while (true);
        
    } // end main()
            
} // end class dataMhs
////////////////////////////////////////////////////////////////////////////////////
