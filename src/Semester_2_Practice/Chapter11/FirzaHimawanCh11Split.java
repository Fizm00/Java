package Semester_2_Practice.Chapter11;

import java.util.*;

public class FirzaHimawanCh11Split {
  public static void main(String[] args) {
    Map<Integer, Set<String>> result = new HashMap<Integer, Set<String>>();

    result.put(2, new TreeSet<String>());
    result.put(3, new TreeSet<String>());
    result.put(4, new TreeSet<String>());
    result.put(8, new TreeSet<String>());

    result.get(2).add("be");
    result.get(2).add("is");
    result.get(2).add("or");
    result.get(2).add("to");

    result.get(3).add("not");
    result.get(3).add("the");

    result.get(4).add("that");

    result.get(8).add("question");

    System.out.println(result); 
  }
}

//Output : {2=[be, is, or, to], 3=[not, the], 4=[that], 8=[question]}