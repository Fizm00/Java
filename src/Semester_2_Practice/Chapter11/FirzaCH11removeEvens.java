package Semester_2_Practice.Chapter11;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.*;

public class FirzaCH11removeEvens {

  public static Set<Integer> removeEvens(Set<Integer> set) {
    Set<Integer> evens = new TreeSet<>();
    Iterator<Integer> iter = set.iterator();
    while (iter.hasNext()) {
      Integer num = iter.next();
      if (num % 2 == 0) {
        evens.add(num);
        iter.remove();
      }
    }
    return evens;
  }

  public static void main(String[] args) {
    Set<Integer> s1 = new TreeSet<>(Arrays.asList(0, 17, 16, 7, 10, 12, 13, 14));
    Set<Integer> s2 = removeEvens(s1);
    System.out.println("s1: " + s1);
    System.out.println("s2: " + s2);
  }

}

/*
 * output:
 * s1: [7, 13, 17]
 * s2: [0, 10, 12, 14, 16]
 */