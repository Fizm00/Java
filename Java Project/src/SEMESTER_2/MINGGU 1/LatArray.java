// contoh array
/////////////////////////////////////////////////////////////////////////

class LatArray {
	public static void main(String[] args) {
		long[] larik; // tipe data dari array
		larik = new long[100]; // membuat array sebanyak maksimum 100
		int nElemen = 0; // untuk menghitung jumlah data dalam array
		int i; 
		long cariData; // data yang dicari
		
//----------------------------------------------------------------------
	// memasukkan data ke dalam array secara manual
	larik[0] = 57; // memasukkan data dalam indek ke-0 dari array
	larik[1] = 89; // memasukkan data dalam indek ke-1 dari array
	larik[2] = 49; // dst...
	larik[3] = 51;
	larik[4] = 12;
	larik[5] = 90;
	larik[6] = 1;
	larik[7] = 0;
	larik[8] = 63;
	larik[9] = 25;
	nElemen = 10; // banyaknya elemen array atau banyaknya data = 10
	
//---------------------------------------------------------------------
	// menampilkan data
	System.out.println("DATA DALAM ARRAY");
	for(i=0; i<nElemen; i++) // menampilkan data array mulai dari indek ke-0
		System.out.print(larik[i] + " ");
	System.out.println("");
	System.out.println("");
	
//---------------------------------------------------------------------
	// mencari data
	System.out.println("MENCARI DATA 5");
	cariData = 5; // mencari data 5
	for(i=0; i<nElemen; i++) // mencari data pada setiap elemen array, mulai dari indek ke-0
		if(larik[i] == cariData) // membandingkan data yg dicari dengan data array yg diakses 
			break; // jika benar maka pencarian dihentikan

	if(i == nElemen) // apabila nilai i sama dengan jumlah data, maka...
		System.out.println("Data " + cariData + " tidak ditemukan ");
	else // bila tidak, maka...
		System.out.println("Data " + cariData + " ditemukan");

	System.out.println("");
		
//---------------------------------------------------------------------
	// menghapus data
	System.out.println("MENGHAPUS DATA 90");
	cariData = 90; // mencari data 90
	for(i=0; i<nElemen; i++)
		if(larik[i] == cariData) // membandingkan data yg dicari dengan data array yg diakses 
			break; // jika benar maka pencarian dihentikan

	for(int j=i; j<nElemen-1; j++) // melakukan penimpaan data pada data yg dihapus dengan data setelahnya
		larik[j] = larik[j+1];
	nElemen--; // jumlah data dikurangi 1

	System.out.println("");
	
//---------------------------------------------------------------------
	// menampilkan data
	System.out.println("DATA DALAM ARRAY SETELAH ADA YANG DIHAPUS");
	for(i=0; i<nElemen; i++) // menampilkan data
		System.out.print( larik[i] + " ");
	System.out.println("");
	
	} // end main()
} // end class latArray