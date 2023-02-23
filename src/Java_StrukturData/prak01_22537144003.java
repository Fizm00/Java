package Java_StrukturData;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

// tugas pertama
import java.util.Scanner;
/////////////////////////////////////////////////////////////////
class metod {
	private int[] dt; // array
	private int jml_data;
	private int i;
//--------------------------------------------------------------
	public metod() { // constructor
		dt = new int[100]; // array sebanyak 100 indek
		jml_data = 0; // jumlah data mula-mula nol
	}
//--------------------------------------------------------------
// method input untuk memasukkan data ke dalam array
	public void input(int data) {
		dt[jml_data] = data;
		jml_data++;
	}
//--------------------------------------------------------------
// method untuk menampilkan data yang ada dalam array
// method tidak mengembalikan nilai (menggunakan void) --> PROCEDURE
	public void lihat () {
		for(i=0; i<jml_data; i++) // menampilkan data
			System.out.println(dt[i]);
		System.out.println("");
	}
//--------------------------------------------------------------
// method untuk mencari data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
	public int cari(int cr) {
        int hitung = 0;
		for(i=0; i<jml_data; i++){ // mencari data pada setiap elemen array
			if(dt[i] == cr) // data pada array sama dengan data yang dicari?
				hitung++;
        }
        return hitung;
	}
//--------------------------------------------------------------
// method untuk menghapus data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
	public int hapus(int hps) {
		int cri = cari(hps);
		for(i=0; i<jml_data; i++){ // mencari data yang akan dihapus
			if(dt[i] == hps){
                for(int j = i; j < jml_data; j++) //penimpaan data
                    dt[j] = dt[j + 1]; //melakukan penimpaan data
                jml_data--; // mengurangi array
                i--; // melakukan pengecekan ulang
            }
        }
        return cri; //mereturn data
	}
} // end class metod

/////////////////////////////////////////////////////////////////////////
class prak01_22537144003 {
	public static void main(String[] args) {
		int i=1, dat, cariData;
		Scanner sken = new Scanner(System.in); //mendeklarasi scanner
		metod md = new metod(); // memanggil class metod dengan variabel md
		
//----------------------------------------------------------------------

		int menu;
		do {
			System.out.println("Pilih Menu di bawah ini");
			System.out.println("1. Memasukkan data");
			System.out.println("2. Pencarian data");
			System.out.println("3. Penghapusan data");
			System.out.println("4. Penampilan data");
			System.out.println("5. Keluar");
			System.out.print("Anda memilih : ");
	  		menu = sken.nextInt();
	  			  		
	  		if (menu==1){ // menu input data
				System.out.print("Jumlah data yang akan dimasukan = "); 
				int jum = sken.nextInt(); // jumlah data yang dimasukkan
				for(int j = 0; j < jum; j++){
					System.out.print("Masukkan data ke-" + i++ + " = ");
					dat = sken.nextInt(); // penginputan data
					md.input(dat); // memanggil method input pada class metod
				}
				System.out.println(jum + " data baru telah disimpan"); // data telah dimasukkan atau disimpan
				System.out.println("");
			}
			
			if (menu==2) { // menu cari data
				System.out.print("Data yang anda cari = ");
				cariData = sken.nextInt(); // data yang akan dicari
				 int hasil = md.cari(cariData); // memanggil method cari pada class metod
				 if (hasil != 0){ // data yang ditemukan 
					 System.out.println("Data " + cariData + " ditemukan dengan jumlah " + hasil); 
			  }else // jika data tidak ditemukan maka akan diberi informasi 
					 System.out.println("Data " + cariData + " tidak ditemukan ");
				 System.out.println("");
							 
		  } else if (menu==3) { // menu hapus data
			  System.out.print("Data yang anda hapus = ");
				 cariData = sken.nextInt(); // data yang akan dihapus
				 int sts = md.hapus(cariData); // memanggil method hapus pada class metod
				 if (sts != 0){ // data telah dihapus
					 System.out.println("Data " + cariData + " sejumlah " + sts + " berhasil dihapus");
				  i -= sts; 
			  }
				 else // jika data yang akan dihapus tidak ditemukan maka akan diberi informasi
					 System.out.println("Data " + cariData + " TIDAK ditemukan");
			  
			  System.out.println("");
  
		  } else if (menu==4) { // menu menampilkan data
			  md.lihat(); // memanggil method lihat pada class metod
		  }
	  } while (menu >= 1 && menu < 5);
	  System.out.println("Program Dihentikan"); // program telah dihentikan
	  System.out.println("");
  } 
}