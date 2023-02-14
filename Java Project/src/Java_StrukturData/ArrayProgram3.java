package Java_StrukturData;

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
                for(int j = i; j < jml_data; j++){ //penimpaan data
                    dt[j] = dt[j + 1]; //melakukan penimpaan data
                }
                jml_data--;
                i--;
            }
        }
        return cri; //mereturn data
	}
} // end class metod

/////////////////////////////////////////////////////////////////////////
class ArrayProgram3 {
	public static void main(String[] args) {
		int i=1, dat, cariData;
		Scanner sken = new Scanner(System.in);
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
	  			  		
	  		if (menu==1){
		  		System.out.print("Masukkan data ke-" + i + " = ");
	  			dat = sken.nextInt();
	  			md.input(dat); // memanggil method input pada class metod
	  			i++;
			}
			
			if (menu==2) {
	  			System.out.print("Data yang anda cari = ");
	 		 	cariData = sken.nextInt();
	  		 	int hasil = md.cari(cariData); // memanggil method cari pada class metod
	  		 	if (hasil != 0) {
	  		 		System.out.println("Data " + cariData + " ditemukan");
                    System.out.println("Data " + cariData + " ditemukan sejumlah " + hasil + " hasil");
                }else
	  		 		System.out.println("Data " + cariData + " tidak ditemukan ");
	  		 	System.out.println("");
	  		 				
			} else if (menu==3) {
				System.out.print("Data yang anda hapus = ");
	  		 	cariData = sken.nextInt();
	  		 	int sts = md.hapus(cariData); // memanggil method hapus pada class metod
	  		 	if (sts != 0)
	  		 		System.out.println("Data " + cariData + " sejumlah " + sts + " berhasil dihapus");
	  		 	else
	  		 		System.out.println("Data " + cariData + " TIDAK ditemukan");
				
				System.out.println("");
	
			} else if (menu==4) {
				md.lihat();
			}
		} while (menu >= 1 && menu < 5);
	} // end main()
} // end class tgsPertamaOK