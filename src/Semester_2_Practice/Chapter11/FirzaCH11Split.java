package Semester_2_Practice.Chapter11;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.*;

public class FirzaCH11Split {

  public static Map<Integer, Set<String>> split(Set<String> words) {
    Map<Integer, Set<String>> map = new HashMap<>();
    for (String word : words) {
      int len = word.length();
      if (!map.containsKey(len)) {
        map.put(len, new HashSet<>());
      }
      map.get(len).add(word);
    }
    return map;
  }

  public static void main(String[] args) {
    Set<String> words = new HashSet<>(Arrays.asList("to", "be", "or", "not", "that", "is", "the", "question"));
    Map<Integer, Set<String>> map = split(words);
    System.out.println(map);
  }

}

//Output : {2=[to, be], 3=[or], 4=[that], 5=[not, this], 6=[is, the], 8=[question]}