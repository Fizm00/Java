package Semester_2_Practice.Chapter11;

//NAMA : FIRZA HIMAWAN
//NIM  : 22537144003

import java.util.ArrayList;
import java.util.List;

public class FirzaCh11Stutter {
  public static void stutter(List<Integer> nums) {
    int size = nums.size();
    for (int i = 0; i < size; i += 2) {
      int num = nums.get(i);
      nums.add(i + 1, num);
      size++;
    }
  }
  
  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<Integer>();
    nums.add(1);
    nums.add(8);
    nums.add(19);
    nums.add(4);
    nums.add(17);
    System.out.println("List sebelum: " + nums);
    stutter(nums);
    System.out.println("List setelah dimodifikasi: " + nums);
  }
}

/*
 * Output:
 * List sebelum: [1, 8, 19, 4, 17]
 * List setelah dimodifikasi: [1, 1, 8, 8, 19, 19, 4, 4, 17, 17]
 */
