package Semester_2_Practice.latihan_random;

// NAMA : Firza Himawan
// NIM  : 22537144003
// RALAT

import java.util.*;
import java.io.*;

public class FirzaMobyDick {
    public static void main(String[] args) {
        Map<String, Integer> kataMap = new HashMap<>();
        
        try {
            // Buka file dan buat scanner untuk membaca file
            Scanner scanner = new Scanner(new File("D:\\Java\\4445774-1722a289b665d940495645a5eaaad4da8e3ad4c7\\mobydick.txt"));
            scanner.useDelimiter("\\s+"); // Pisahkan input berdasarkan spasi atau newline
            
            // Baca file dan masukkan ke Map
            while (scanner.hasNext()) {
                String[] kata = scanner.next().split("\\W+");
                for (String k : kata) {
                    k = k.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!k.isEmpty()) {
                        kataMap.put(k, kataMap.getOrDefault(k, 0) + 1);
                    }
                }
            }
            scanner.close();
            
            // Buat ArrayList dari Map
            List<Map.Entry<String, Integer>> kataList = new ArrayList<>(kataMap.entrySet());
            kataList.sort(Map.Entry.comparingByValue());
            
            // Urutkan ArrayList berdasarkan value
            Collections.sort(kataList, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
            });
            
            // Cetak kata-kata yang memiliki value >= 1000
            System.out.println("Peringkat kata-kata:");
            int rank = 1;
            for (Map.Entry<String, Integer> entry : kataList) {
                if (entry.getValue() >= 1000) {
                    System.out.println(rank + ". " + entry.getKey() + ": " + entry.getValue());
                    rank++;
                }
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
 * output: 
 * 1. he: 1037
 * 2. it: 1196
 * 3. i: 1315
 * 4. his: 1332
 * 5. that: 1559
 * 6. in: 2145
 * 7. to: 2416
 * 8. a: 2575
 * 9. and: 3214
 * 10. of: 3532
 * 11. the: 7032
 */


