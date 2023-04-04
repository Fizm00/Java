package Semester_2_Practice.Chapter11;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.*;

public class FirzaCH11Counts {

  public static Map<Integer, Integer> counts(List<Integer> list, Set<Integer> set) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer num : set) {
      int count = 0;
      for (Integer elem : list) {
        if (elem.equals(num)) {
          count++;
        }
      }
      map.put(num, count);
    }
    return map;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(4, -2, 3, 9, 4, 17, 5, 29, 14, 87, 4, -2, 100);
    Set<Integer> set = new HashSet<>(Arrays.asList(-2, 4, 29));
    Map<Integer, Integer> map = counts(list, set);
    System.out.println(map);
  }

}

//Output : {-2=2, 4=3, 29=1}