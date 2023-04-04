package Semester_2_Practice.latihan_random;

// Travis Zusa Zuve Saputra
// 22537141013

import java.util.*;
import java.io.*;

public class TravisMobyDick {
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
Peringkat kata-kata:
1. he: 1036
2. it: 1195
3. i: 1312
4. his: 1332
5. that: 1559
6. in: 2143
7. to: 2403
8. a: 2547
9. and: 3207
10. of: 3519
11. the: 7025
*/