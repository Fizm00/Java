package Java_StrukturData;

//Nama : Firza Himawan
//NIM  : 22537144003

// penyimpanan data mahasiswa
import java.util.Scanner;
/////////////////////////////////////////////////////////////////

// class untuk menyimpan data mahasiswa -> membuat tipe data ADT
class mahasiswa { // mahasiswa mempunyai 3 data, nim, nama, dan ipk
	public String nimMhs;
	private String namaMhs;
	private double ipkMhs;
//--------------------------------------------------------------
	// constructor
	// berguna juga untuk "memasukkan" data mahasiswa
	public mahasiswa(String nim, String nama, double ipk) {
		nimMhs = nim;
		namaMhs = nama;
		ipkMhs = ipk;
	}
//--------------------------------------------------------------
	// method untuk menampilkan data mahasiswa
	public void lihatData() {
		System.out.println(nimMhs + " --> " + namaMhs + " --> " + ipkMhs);
	}
//--------------------------------------------------------------
	// method memperoleh (mengambil) data nama
	public String getNim()
		{ return nimMhs; }
//--------------------------------------------------------------
	public String getNama()
		{ return namaMhs; }
//--------------------------------------------------------------
	public double getIpk()
		{ return ipkMhs; }
} // end class mahasiswa
/////////////////////////////////////////////////////////////////

//class untuk menyimpan data mahasiswa di array
class arai {
	private mahasiswa[] dt; // membuat array dengan tipe data ADT 
	private int jml_data;
	private int i;
//--------------------------------------------------------------
	public arai(int max) { // constructor
		dt = new mahasiswa[max]; // creating array
		jml_data = 0; // jumlah data mula-mula nol
	}
//--------------------------------------------------------------
	public boolean cekNim(String nim) {
		boolean hsl=cariNim(nim);
		if (hsl==true)
			return true;
		else
			return false;
	}
	
	public boolean cariNim(String nim) {
		for(i=0; i<jml_data; i++) // mencari data pada setiap elemen array
			if( dt[i].getNim().equals(nim) ) // membandingkan data pada array dengan yang dicari
				break; // jika sama maka pencarian dihentikan
		if(i == jml_data) // apakah pencarian yang dilakukan sebanyak jumlah elemen array?
			return false; // jika true data TIDAK ditemukan (false)
		else
			return true; // jika false data ditemukan (true)
	}
	
	// method input untuk memasukkan data ke dalam array
	public void input(String nim, String nama, double ipk) {
		boolean cekN = cekNim(nim);
		if (cekN==true)
			System.out.println("Tambah data GAGAL, NIM sudah ada!!!");
		else {
			dt[jml_data] = new mahasiswa(nim,nama,ipk);
			jml_data++; // jika ada data masuk maka jumlah datanya bertambah
			System.out.println("Tambah data BERHASIL");
		}
	}
	
	// method dataArai untuk menampilkan data yang ada dalam array
	// method tidak mengembalikan nilai (menggunakan void) --> PROCEDURE
	public void dataArai() { // menampilkan isi dari array
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("NIM       Nama        IPK");
        System.out.println("----------------------------");
        for(i=0; i<jml_data; i++)
            dt[i].lihatData(); // memanggil method lihatData() dari class mahasiswa
        System.out.println("----------------------------");
    }
    
    // method hapus untuk menghapus data berdasarkan NIM
    public void hapus(String nim) {
        boolean cekN = cekNim(nim);
        if (cekN==true) {
            for(i=0; i<jml_data; i++) {
                if( dt[i].getNim().equals(nim) ) // mencari data pada array dengan NIM yang diberikan
                    break; // jika data ditemukan, pencarian dihentikan
            }
            // menghapus data pada array dengan menggeser elemen array setelahnya
            for(int j=i; j<jml_data-1; j++) {
                dt[j] = dt[j+1];
            }
            jml_data--; // mengurangi jumlah data setelah data terhapus
            System.out.println("Data dengan NIM " + nim + " berhasil dihapus.");
        }
        else
            System.out.println("Data dengan NIM " + nim + " tidak ditemukan.");
    }
    
    // method update untuk mengubah data mahasiswa berdasarkan NIM
    public void update(String nim,String baru) {
        boolean cekN = cekNim(nim);
        if (cekN==true) {
            for(i=0; i<jml_data; i++) {
                if( dt[i].getNim().equals(nim) ) // mencari data pada array dengan NIM yang diberikan
                    break; // jika data ditemukan, pencarian dihentikan
            }
            dt[i].nimMhs=baru; // mengganti data dengan NIM yang diberikan
            System.out.println("Data dengan NIM " + nim + " berhasil diubah.");
        }
        else
            System.out.println("Data dengan NIM " + nim + " tidak ditemukan.");
    }
} // end class arai
/////////////////////////////////////////////////////////////////
// class utama untuk memanggil class arai dan mahasiswa
public class prak02_22537144003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // deklarasi scanner
        int max, pilih;
        String nim, nama;
        double ipk;
        boolean selesai = false;

        System.out.print("Masukkan jumlah mahasiswa maksimum: ");
        max = input.nextInt(); // input ukuran maksimum objek array

        arai mhsArray = new arai(max); // membuat objek array mahasiswa dengan maksimum yang ditentukan

        while(!selesai) {
            System.out.println("");
            System.out.println("Aplikasi Data Mahasiswa");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Update Data");
            System.out.println("4. Lihat Data");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilih = input.nextInt();

            switch(pilih) {
                case 1: // menu 1 untuk tambah data
                    System.out.print("NIM: ");
                    nim = input.next(); // input NIM mahasiswa
                    System.out.print("Nama: ");
                    nama = input.next(); // input Nama mahasiswa
                    System.out.print("IPK: ");
                    ipk = input.nextDouble(); // input IPK mahasiswa
                    mhsArray.input(nim, nama, ipk); // pemanggilan method input pada class arrai untuk tambah data
                    break;

                case 2: // menu 2 untuk hapus data
                    System.out.print("NIM yang akan dihapus: ");
                    nim = input.next(); // input NIM yang akan dihapus
                    mhsArray.hapus(nim); // pemanggilan method hapus pada class arrai untuk hapus data
                    break;

                case 3: // menu 3 untuk update data
                    String baru; // deklarasi nim baru
                    System.out.print("NIM yang akan diupdate: ");
                    nim = input.next(); // input NIM yang akan diupdate
                    System.out.print("NIM baru: ");
                    baru = input.next(); // input NIM baru
                    mhsArray.update(nim,baru); // pemanggilan method update pada class arrai untuk update data
                    break;

                case 4: // menu 4 untuk lihat data
                    mhsArray.dataArai(); // pemanggilan method dataArai pada class arrai untuk lihat data
                    break;

                case 5: // menu 5 untuk mengakhiri program
                    selesai = true; 
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!"); // jika input menu tidak sesuai
            }
        }
    }
}